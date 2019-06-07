package th.co.softpos.ws.model;

import lombok.Data;

@Data
public class ServiceActivate {

    private String brandId;
    private String branchId;
    private String terminalId;
    private String serialNumber;
    private String activationCode;

}
