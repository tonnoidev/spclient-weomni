package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Transaction;
import th.co.softpos.ws.model.Customer;

@Data
public class RedeemCampaignDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private String trueYouId;
    private Transaction transaction;
    private Customer customer;

}
