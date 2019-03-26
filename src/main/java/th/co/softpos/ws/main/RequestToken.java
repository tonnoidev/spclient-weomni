package th.co.softpos.ws.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import th.co.softpos.ws.client.POSConstant;
import th.co.softpos.ws.client.WSConstants;

// curl -u h0NI9uOB1YTVdsxy48s3JDpkp94Bl4Lb:sWVbMBtLXY1mySMh https://api.weomni-test.com/oauth/token -d "grant_type=client_credentials"
public class RequestToken {

    public static String toPrettyFormat(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    public static void process() throws Exception {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT.%1$tL %4$s %5$s%6$s%n");

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        
        // This block configure the logger with handler and formatter
        fh = new FileHandler("logs/WeOmni-Request-Token-LogFile.log", true);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        // Change parameter values according to your company POS
        String CLIENT_ID = POSConstant.CLIENT_ID; // put your "client_secret"
        String CLIENT_SECRET = POSConstant.CLIENT_SECRET; // put your "client_secret"
        String dtype = "grant_type=client_credentials";
        URL url = new URL(WSConstants.URL_AUTH); // Staging
        //URL url = new URL(POS.URL_PRODUCTION); // Production

        String auth = CLIENT_ID + ":" + CLIENT_SECRET;
        byte[] authBytes = auth.getBytes(StandardCharsets.UTF_8);
        String encoded = Base64.getEncoder().encodeToString(authBytes);
        String authHeader = "Basic " + encoded;

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", authHeader);
        con.setConnectTimeout(60000); // timeout = 60 sec.
        con.setDoInput(true);
        con.setDoOutput(true);
        logger.info("RequestToken POST JSON to " + url);

        OutputStream os = con.getOutputStream();
        os.write(dtype.getBytes());
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        switch (responseCode) {
            case HttpURLConnection.HTTP_OK:
                logger.info(responseCode + " OK : ** Successful ** ");
                logger.info("Response JSON \n" + toPrettyFormat(response.toString()));
                break; // fine, go on
            case HttpURLConnection.HTTP_GATEWAY_TIMEOUT:
                logger.warning(responseCode + " : ** gateway timeout ** ");
                logger.warning("Response JSON \n" + response.toString());
                break; // retry
            case HttpURLConnection.HTTP_UNAVAILABLE:
                logger.warning(responseCode + " : ** unavailable ** ");
                logger.warning("Response JSON \n" + response.toString());
                break; // retry, server is unstable
            case 400:
                logger.warning(responseCode + " : ** Bad Request ** ");
                logger.warning("Response JSON \n" + response.toString());
                break; // Bad Request
            case 401:
                logger.warning(responseCode + " : ** Unauthorized ** ");
                logger.warning("Response JSON \n" + response.toString());
                break; // Unauthorized
            case 404:
                logger.warning(responseCode + " : **Not Found** ");
                logger.warning("Response JSON \n" + response.toString());
                break; // Not Found
            case 500:
                logger.severe(responseCode + " : **Internal Server Error** ");
                logger.severe("Response JSON \n" + response.toString());
                break; // Internal Server Error
            default:
                logger.severe(responseCode + " : **unknown response code** ");
                logger.severe("Response JSON \n" + response.toString());
                break; // abort
        } // end switch case
    }
}
