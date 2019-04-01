package th.co.softpos.ws.dto;

import lombok.Data;

@Data
public class CreateVoidPaymentDTO {

    private String brandId;
    private String branchId;
    private Boolean external;
}
