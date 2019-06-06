package th.co.softpos.ws.client;

public class POSConstant {

    public static String CLIENT_ID;
    public static String CLIENT_SECRET;
    public static String ACCESS_TOKEN;
    public static String APP_ID;
    
    public static final int WAIT_FOR_TIMEOUT = 3;
    public static final int TIMEOUT = 3000 * WAIT_FOR_TIMEOUT;
    public static final int SCHEDULE_TASK = 5000;

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
