package th.co.softpos.db.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ServiceReq {

    private String uid;
    private String activationCode;
    private String imei;
    private String latitude;
    private String longitude;
    private String password;
    private String external;
    private String brandId;
    private String branchId;
    private String campaignCode;
    private String accountType;
    private String accountValue;
    private String rewardCode;
    private String earnPointAmount;
    private BigDecimal amount;
    private BigDecimal paymentAmount;
    private String paymentCurrency;
    private String paymentCode;
    private String paymentMethod;
    private String paymentDescription;
    private String reqId;
    private String reqStatus;
    private Date reqDatetime;
    private String apiName;
    private String paramTerminalId;
    private String paramTraceId;
    private String redeemType;
    
}
