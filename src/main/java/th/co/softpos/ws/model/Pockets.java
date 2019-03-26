package th.co.softpos.ws.model;

public class Pockets {

    private String description;
    private Integer balance;
    private String expired;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "Pockets{" + "description=" + description + ", balance=" + balance + ", expired=" + expired + '}';
    }

}
