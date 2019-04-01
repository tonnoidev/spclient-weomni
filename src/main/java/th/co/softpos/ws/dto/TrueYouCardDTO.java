package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Point;
import th.co.softpos.ws.model.SlipType;

@Data
public class TrueYouCardDTO {

    private String no;
    private String name;
    private String type;
    private String status;
    private String expired;
    private Point point;
    private SlipType slipType;

}
