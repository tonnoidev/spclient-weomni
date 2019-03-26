package th.co.softpos.ws.model;

public class Transaction {

    private String traceId;
    private String batchId;
    private String transactionReferenceId;
    private String transactionDate;
    private Integer points;
    private Integer amount;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getTransactionReferenceId() {
        return transactionReferenceId;
    }

    public void setTransactionReferenceId(String transactionReferenceId) {
        this.transactionReferenceId = transactionReferenceId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "traceId=" + traceId + ", batchId=" + batchId + ", transactionReferenceId=" + transactionReferenceId + ", transactionDate=" + transactionDate + ", points=" + points + ", amount=" + amount + '}';
    }

}
