package th.co.softpos.ws.model;

import lombok.Data;

@Data
public class Account {

    private String type;
    private String value;

    public Account(String type, String value) {
        this.type = type;
        this.value = value;
    }

}
