package th.co.softpos.ws.model;

import lombok.Data;

@Data
public class Content {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Campaign campaign;

}
