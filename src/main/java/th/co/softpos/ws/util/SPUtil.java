package th.co.softpos.ws.util;

import java.math.BigDecimal;

public class SPUtil {

    public static String parseUriFormat(String apiUri, String... query) {
        String[] str = apiUri.split("[\\{\\}]");
        int countQuery = 0;
        for (int i = 0; i < str.length; i++) {
            if (i % 2 != 0) {
                apiUri = apiUri.replace("{" + str[i] + "}", query[countQuery]);
                countQuery++;
            }
        }

        return apiUri;
    }

    public static Integer parseAmout100(String amount) {
        BigDecimal amt = new BigDecimal(amount);
        return amt.intValue() * 100;
    }

    public static Integer parseAmout100(BigDecimal amount) {
        return amount.intValue() * 100;
    }

}
