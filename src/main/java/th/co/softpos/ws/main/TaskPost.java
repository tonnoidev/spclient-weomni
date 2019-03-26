package th.co.softpos.ws.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import th.co.softpos.ws.client.POSConstant;
import th.co.softpos.ws.client.WSConstants;

public class TaskPost {

    public static void main(String[] args) {
        sendGet();
    }

    private static String getStreamStr(InputStream is) {
        return new Scanner(is, "UTF-8").useDelimiter("\\Z").next();
    }

    private static String sendGet() {
        String json = null;
        try {
            URL url = new URL(WSConstants.API_POS_HEALTH);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setInstanceFollowRedirects(false);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("charset", "utf-8");
            con.setConnectTimeout(5000);
            con.connect();

            int status = con.getResponseCode();
            String msg = con.getResponseMessage();

            InputStream inStream = con.getInputStream();
            json = getStreamStr(inStream); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return json;
    }

    private static String sendPost() {
//        String tokenResponse = getToken();

        String json = null;
        try {
            URL url = new URL(WSConstants.API_ACTIVATE);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("charset", "utf-8");
            con.setRequestProperty("Authorization", "Bearer " + POSConstant.ACCESS_TOKEN);
            con.setConnectTimeout(5000);

            String jsonData = "{\n"
                    + "  \"activationCode\": \"99999999\",\n"
                    + "  \"imei\": \"869826022379141\",\n"
                    + "  \"latitude\": 13.7645001,\n"
                    + "  \"longitude\": 100.5679174,\n"
                    + "  \"password\": \"2222\",\n"
                    + "  \"external\": false\n"
                    + "}";
            /*
                {
                    "activationCode": "99999999",
                    "imei": "869826022379141",
                    "latitude": 13.7645001,
                    "longitude": 100.5679174,
                    "password": "2222",
                    "external": false
                }
             */
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(jsonData);
                wr.flush();
            }

            int status = con.getResponseCode();
            String msg = con.getResponseMessage();

            StringBuilder response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            json = response.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return json;
    }

    private static String getToken() {
        Logger logger = Logger.getLogger("SoftLog");
        String tokenResponse = null;

        // request token
        try {
            String CLIENT_ID = POSConstant.CLIENT_ID;
            String CLIENT_SECRET = POSConstant.CLIENT_SECRET;
            String dtype = "grant_type=client_credentials";
            URL url = new URL(WSConstants.URL_AUTH);

            String auth = CLIENT_ID + ":" + CLIENT_SECRET;
            byte[] authBytes = auth.getBytes(StandardCharsets.UTF_8);
            String encoded = Base64.getEncoder().encodeToString(authBytes);
            String authHeader = "Basic " + encoded;

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", authHeader);
            con.setConnectTimeout(60000);
            con.setDoInput(true);
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                os.write(dtype.getBytes());
                os.flush();
            }

            int responseCode = con.getResponseCode();
            StringBuilder response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            switch (responseCode) {
                case HttpURLConnection.HTTP_OK:
                    logger.log(Level.INFO, "{0} OK : ** Successful ** ", responseCode);
                    break; // fine, go on
                case HttpURLConnection.HTTP_GATEWAY_TIMEOUT:
                    logger.log(Level.WARNING, "{0} : ** gateway timeout ** ", responseCode);
                    break; // retry
                case HttpURLConnection.HTTP_UNAVAILABLE:
                    logger.log(Level.WARNING, "{0} : ** unavailable ** ", responseCode);
                    break; // retry, server is unstable
                case 400:
                    logger.log(Level.WARNING, "{0} : ** Bad Request ** ", responseCode);
                    break; // Bad Request
                case 401:
                    logger.log(Level.WARNING, "{0} : ** Unauthorized ** ", responseCode);
                    break; // Unauthorized
                case 404:
                    logger.log(Level.WARNING, "{0} : **Not Found** ", responseCode);
                    break; // Not Found
                case 500:
                    logger.log(Level.SEVERE, "{0} : **Internal Server Error** ", responseCode);
                    break; // Internal Server Error
                default:
                    logger.log(Level.SEVERE, "{0} : **unknown response code** ", responseCode);
                    break; // abort
            }
            tokenResponse = response.toString();
            logger.log(Level.SEVERE, "Response JSON \n{0}", response.toString());
        } catch (IOException e) {
            Logger.getLogger(TaskPost.class.getName()).log(Level.SEVERE, e.getMessage());
        }

        /*
        INFO: Response JSON 
            {
              "refresh_token_expires_in": "0",
              "api_product_list": "[pos-partner-services]",
              "api_product_list_json": [
                "pos-partner-services"
              ],
              "organization_name": "weomni",
              "developer.email": "md@softpos.co.th",
              "token_type": "Bearer",
              "issued_at": "1553308347303",
              "client_id": "aYYU357MyCYhObJ9OC1PC5TVbemloozG",
              "access_token": "oH1KpGj6RDylZgb62vYfVi47LUYG",
              "application_name": "427bcc7f-5853-4281-9e1b-af34a1714d02",
              "scope": "",
              "expires_in": "0",
              "refresh_count": "0",
              "status": "approved"
            }
         */
        return tokenResponse;
    }

}