package th.co.softpos.ws.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ActivateDTO implements Serializable {

    private String brandId;
    private String branchId;
    private String terminalId;
    private String serialNumber;
    private String activationCode;

}
