package th.co.softpos.ws.dto;

import lombok.Data;

@Data
public class CreateRedeemCodeDTO {

    private String brandId;
    private String branchId;
    private String campaignCode;
    private String rewardCode;
    private Boolean external;

}
