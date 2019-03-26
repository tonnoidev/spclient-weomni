package th.co.softpos.ws.model;

import java.util.List;

public class Point {

    private Integer balance;
    private Pockets[] pockets;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Pockets[] getPockets() {
        return pockets;
    }

    public void setPockets(Pockets[] pockets) {
        this.pockets = pockets;
    }

    @Override
    public String toString() {
        return "Point{" + "balance=" + balance + ", pockets=" + pockets + '}';
    }

}
