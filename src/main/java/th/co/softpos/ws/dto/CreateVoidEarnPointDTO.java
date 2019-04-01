package th.co.softpos.ws.dto;

import lombok.Data;

@Data
public class CreateVoidEarnPointDTO {

    private String brandId;
    private String branchId;
    private Boolean external;

}
