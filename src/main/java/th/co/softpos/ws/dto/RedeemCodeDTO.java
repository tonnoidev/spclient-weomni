package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Transaction;

@Data
public class RedeemCodeDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Transaction transaction;
    private String trueYouId;
    private String rewardCode;

}
