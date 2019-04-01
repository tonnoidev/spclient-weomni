package th.co.softpos.ws.model;

import lombok.Data;

@Data
public class Payment {

    private String amount;
    private String currency;
    private String code;
    private String method;
    private String description;

    private String traceId;
    private String batchId;
    private String transactionReferenceId;
    private String transactionDate;

}
