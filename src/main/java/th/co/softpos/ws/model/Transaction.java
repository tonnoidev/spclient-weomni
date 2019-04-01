package th.co.softpos.ws.model;

import lombok.Data;

@Data
public class Transaction {

    private String traceId;
    private String batchId;
    private String transactionReferenceId;
    private String transactionDate;
    private Integer points;
    private Integer amount;

}
