package th.co.softpos.ws.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class MySQLConnect {

    public static String server;
    public static String db;
    public static String username;
    public static String password;
    public static String port;
    public static String charset;
    public static String fontSize;
    public static String inputTable;

    static {
        try {
            File file = new File("app/db.properties");

            try (InputStream input = new FileInputStream(file)) {
                Properties prop = new Properties();
                prop.load(input);

                server = prop.getProperty("mysql.server");
                db = prop.getProperty("mysql.db");
                username = prop.getProperty("mysql.username");
                password = prop.getProperty("mysql.password");
                port = prop.getProperty("mysql.port");
                charset = prop.getProperty("mysql.charset");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IO Error", "File Error \n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }

}
