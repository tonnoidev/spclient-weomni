package th.co.softpos.ws.model;

public class Customer {

    private String customerReferenceId;
    private String pointUsed;
    private String pointBalance;

    public String getCustomerReferenceId() {
        return customerReferenceId;
    }

    public void setCustomerReferenceId(String customerReferenceId) {
        this.customerReferenceId = customerReferenceId;
    }

    public String getPointUsed() {
        return pointUsed;
    }

    public void setPointUsed(String pointUsed) {
        this.pointUsed = pointUsed;
    }

    public String getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(String pointBalance) {
        this.pointBalance = pointBalance;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerReferenceId=" + customerReferenceId + ", pointUsed=" + pointUsed + ", pointBalance=" + pointBalance + '}';
    }

}
