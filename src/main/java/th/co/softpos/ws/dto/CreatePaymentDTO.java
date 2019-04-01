package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.req.Payment;

@Data
public class CreatePaymentDTO {

    private String brandId;
    private String branchId;
    private Payment payment;
    private Boolean external;

}
