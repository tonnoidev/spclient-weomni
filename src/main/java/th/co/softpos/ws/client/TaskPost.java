package th.co.softpos.ws.client;

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

public class TaskPost {

    private static String getStreamStr(InputStream is) {
        return new Scanner(is, "UTF-8").useDelimiter("\\Z").next();
    }

    public static String sendGet(String apiUri) throws Exception {
        String json;
        try {
            URL url = new URL(apiUri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setInstanceFollowRedirects(false);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("charset", "utf-8");
            con.setRequestProperty("Authorization", "Bearer " + POSConstant.ACCESS_TOKEN);
            con.setConnectTimeout(POSConstant.TIMEOUT);
            con.connect();

            int status = con.getResponseCode();
            String msg = con.getResponseMessage();

            if (status == HttpURLConnection.HTTP_OK) {
                if (WSConstants.API_POS_HEALTH.equals(apiUri)) {
                    json = "Service is available";
                    return json;
                } else {
                    InputStream inStream = con.getInputStream();
                    json = getStreamStr(inStream);
                }
            } else {
                json = "     status:" + status + " , msg:" + msg;
                json += getStreamStr(con.getErrorStream());
            }
        } catch (IOException ex) {
            json = null;
            throw ex;
        }

        return json;
    }

    public static String sendPost(String jsonData, String apiUri) throws Exception {
        String json = null;
        try {
            URL url = new URL(apiUri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("charset", "utf-8");
            con.setRequestProperty("Authorization", "Bearer " + POSConstant.ACCESS_TOKEN);
            con.setConnectTimeout(POSConstant.TIMEOUT);

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(jsonData);
                wr.flush();
            }

            int status = con.getResponseCode();
            String msg = con.getResponseMessage();

            if (status == HttpURLConnection.HTTP_OK) {
                StringBuilder response;
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }

                json = response.toString();
            } else {
                json = "     status:" + status + " , msg:" + msg;
                json += getStreamStr(con.getErrorStream());

            }
        } catch (IOException ex) {
            throw ex;
        }

        return json;
    }

    public static String getToken(String clientId, String clientSecret) {
        Logger logger = Logger.getLogger("SoftLog");
        String tokenResponse = null;

        // request token
        try {
            String CLIENT_ID = POSConstant.CLIENT_ID;
            if (!"".equals(clientId)) {
                CLIENT_ID = clientId;
            }
            String CLIENT_SECRET = POSConstant.CLIENT_SECRET;
            if (!"".equals(clientSecret)) {
                CLIENT_SECRET = clientSecret;
            }
            String dtype = "grant_type=client_credentials";
            URL url = new URL(WSConstants.URL_AUTH);

            String auth = CLIENT_ID + ":" + CLIENT_SECRET;
            byte[] authBytes = auth.getBytes(StandardCharsets.UTF_8);
            String encoded = Base64.getEncoder().encodeToString(authBytes);
            String authHeader = "Basic " + encoded;

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", authHeader);
            con.setConnectTimeout(POSConstant.TIMEOUT);
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

        return tokenResponse;
    }

}
