package th.co.softpos.ws.dto;

import lombok.Data;

@Data
public class ErrorDTO {

    private String code;
    private String displayCode;
    private String messsage;
    private FieldDTO []fields;

}
