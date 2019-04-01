package th.co.softpos.ws.model;

import lombok.Data;

@Data
public class Campaign {

    private String code;
    private String name;
    private String imageUrl;
    private String start;
    private String end;
    private String lastModifiedDate;
    private String status;

}
