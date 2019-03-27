package th.co.softpos.ws.client;

public class WSConstants {

    public static final String DB_SERVICES = "pos_services";

    public static final String URL_AUTH = "https://api.weomni-test.com/oauth/token";
    public static final String URL_PRODUCTION = "https://api.weomni.com/oauth/token";

    private static final String HOST_API = "https://staging-api2.weomni-test.com";

    // List all Activate API
    public static final String API_ACTIVATE = HOST_API + "/v1/terminals/activate";

    // List all Privilege API
    public static final String API_PRIVILEGE_REDEEM_CAMPAIGN = HOST_API + "/privilege/v1/terminals/{terminalId}/redeem-campaign";
    public static final String API_PRIVILEGE_REDEEM_CODE = HOST_API + "/privilege/v1/terminals/{terminalId}/redeem-code";
    public static final String API_PRIVILEGE_EARN_POINT = HOST_API + "/privilege/v1/terminals/{terminalId}/earn-point";
    public static final String API_PRIVILEGE_TRUE_YOU_CARD = HOST_API + "/privilege/v1/terminals/{69000132}/true-you-card"
            + "?brandId={1100001}&branchId={00132}&accountType={THAIID}&accountValue={1234}&external={false}";
    public static final String API_PRIVILEGE_EARN_POINT_VOID = HOST_API + "/privilege/v1/terminals/{terminalId}/earn-point/{traceId}/void";
    public static final String API_PRIVILEGE_BURN_POINT_VOID = HOST_API + "/privilege/v1/terminals/{terminalId}/burn-point/{traceId}/void";

    // List all Campaign API
    public static final String API_CAMPAIGN = HOST_API + "/campaign/v1/terminals/{69000132}"
            + "?brandId={1100001}&branchId={00132}&redeemType={REDEEM_BY_CAMPAIGN}&external={false}";

    // List all Payment API
    public static final String API_PAYMENTS = HOST_API + "/payment/v1/terminals/{terminalId}/payments";
    public static final String API_PAYMENTS_VOID = HOST_API + "/payment/v1/terminals/{terminalId}/payments/{traceId}/void";

    // Health check
    public static final String API_POS_HEALTH = HOST_API + "/pos/health";

}
