package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Account;
import th.co.softpos.ws.model.Transaction;

@Data
public class EarnPointDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Transaction transaction;
    private String trueYouId;
    private Account account;

}
