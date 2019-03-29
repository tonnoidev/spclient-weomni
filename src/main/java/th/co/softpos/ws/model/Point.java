package th.co.softpos.ws.model;

import java.util.List;

public class Point {

    private Integer balance;
    private List<Pockets> pockets;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<Pockets> getPockets() {
        return pockets;
    }

    public void setPockets(List<Pockets> pockets) {
        this.pockets = pockets;
    }

    @Override
    public String toString() {
        return "Point{" + "balance=" + balance + ", pockets=" + pockets + '}';
    }

}
