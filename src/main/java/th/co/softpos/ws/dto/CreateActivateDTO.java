package th.co.softpos.ws.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateActivateDTO {

    private String activationCode;
    private String imei;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String password;
    private Boolean external;

}
