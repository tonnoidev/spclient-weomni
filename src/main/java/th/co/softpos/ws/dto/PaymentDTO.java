package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Payment;

@Data
public class PaymentDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Payment payment;
    private String trueYouId;

}
