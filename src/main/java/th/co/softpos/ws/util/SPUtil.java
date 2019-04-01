package th.co.softpos.ws.util;

import java.math.BigDecimal;

public class SPUtil {

    public static String parseUriFormat(String apiUri, String... query) {
        String[] str = apiUri.split("[\\{\\}]");
        int countQuery = 0;
        for (int i = 0; i < str.length; i++) {
            if (i % 2 != 0) {
                String dataRep = query[countQuery] == null ? "" : query[countQuery];
                apiUri = apiUri.replace("{" + str[i] + "}", dataRep);
                countQuery++;
            }
        }

        return apiUri;
    }

    public static Integer parseAmout100(String amount) {
        if (amount == null) {
            return 0;
        }
        BigDecimal amt = new BigDecimal(amount);
        return amt.intValue() * 100;
    }

    public static Integer parseAmout100(BigDecimal amount) {
        if (amount == null) {
            return 0;
        }
        return amount.intValue() * 100;
    }

}
