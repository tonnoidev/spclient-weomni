package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Campaign;
import th.co.softpos.ws.model.Account;
import th.co.softpos.ws.model.Payment;

@Data
public class VoidPaymentDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private String transactionType;
    private Payment payment;
    private Account account;
    private String trueYouId;
    private Campaign campaign;
    private String point;

}
