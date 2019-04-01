package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Account;

@Data
public class CreateRedeemCampaignDTO {

    private String brandId;
    private String branchId;
    private String campaignCode;
    private Account account;
    private Boolean external;

}
