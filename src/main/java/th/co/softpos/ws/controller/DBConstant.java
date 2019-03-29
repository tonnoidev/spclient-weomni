package th.co.softpos.ws.controller;

public class DBConstant {

    public static final String CLASS_NAME = "com.mysql.jdbc.Driver";
    public static String DRIVER = "jdbc:mysql://" + MySQLConnect.server + ":" + MySQLConnect.port + "/" + MySQLConnect.db + "?charset=" + MySQLConnect.charset;
    public static String USERNAME = MySQLConnect.username;
    public static String PASSWORD = MySQLConnect.password;

}
