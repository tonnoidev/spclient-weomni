package th.co.softpos.ws.dto;

import lombok.Data;
import th.co.softpos.ws.model.Account;

@Data
public class CreateEarnPointDTO {

    private String brandId;
    private String branchId;
    private Account account;
    private Integer amount;
    private Boolean external;

}
