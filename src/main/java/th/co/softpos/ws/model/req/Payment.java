package th.co.softpos.ws.model.req;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + ", currency=" + currency + ", code=" + code + ", method=" + method + ", description=" + description + "}";
    }

}
