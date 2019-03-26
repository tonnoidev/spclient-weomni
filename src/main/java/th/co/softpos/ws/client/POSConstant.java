package th.co.softpos.ws.client;

public class POSConstant {

    public static String CLIENT_ID = "aYYU357MyCYhObJ9OC1PC5TVbemloozG";
    public static String CLIENT_SECRET = "r0Zr3u4JZPrUjaa4";    
    public static final String ACCESS_TOKEN = "oH1KpGj6RDylZgb62vYfVi47LUYG";

    // services trigger
    // List all Activate TRIGGER
    public static final int TRIGGER_ACTIVATE = 1;

    // List all Privilege TRIGGER
    public static final int TRIGGER_PRIVILEGE_REDEEM_CAMPAIGN = 2;
    public static final int TRIGGER_PRIVILEGE_REDEEM_CODE = 3;
    public static final int TRIGGER_PRIVILEGE_EARN_POINT = 4;
    public static final int TRIGGER_PRIVILEGE_TRUE_YOU_CARD = 5;
    public static final int TRIGGER_PRIVILEGE_EARN_POINT_VOID = 6;
    public static final int TRIGGER_PRIVILEGE_BURN_POINT_VOID = 7;

    // List all Campaign TRIGGER
    public static final int TRIGGER_CAMPAIGN = 8;

    // List all Payment TRIGGER
    public static final int TRIGGER_PAYMENTS = 9;
    public static final int TRIGGER_PAYMENTS_VOID = 10;

    // Health check
    public static final int TRIGGER_POS_HEALTH = 11;
}
