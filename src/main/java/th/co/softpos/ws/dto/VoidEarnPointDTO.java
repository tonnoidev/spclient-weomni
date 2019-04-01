package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Account;
import th.co.softpos.ws.model.Campaign;
import th.co.softpos.ws.model.Payment;
import th.co.softpos.ws.model.Transaction;

@Data
public class VoidEarnPointDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Transaction transaction;
    private String trueYouId;
    private Account account;
    private Payment payment;
    private String transactionType;
    private Campaign campaign;
    private String point;

}
