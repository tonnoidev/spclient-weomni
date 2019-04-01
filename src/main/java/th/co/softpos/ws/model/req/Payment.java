package th.co.softpos.ws.model.req;

import lombok.Data;

@Data
public class Payment {

    private String amount;
    private String currency;
    private String code;
    private String method;
    private String description;

    public Payment(String amount, String currency, String code, String method, String description) {
        this.amount = amount;
        this.currency = currency;
        this.code = code;
        this.method = method;
        this.description = description;
    }

}
