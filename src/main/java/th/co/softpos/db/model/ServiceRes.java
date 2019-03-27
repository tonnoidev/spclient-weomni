package th.co.softpos.db.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ServiceRes {

    private String uid;
    private String reqId;
    private String brandId;
    private String branchId;
    private String terminalId;
    private String serialNo;
    private String actCode;
    private String trueYouId;
    private String tranTracId;
    private String tranBatId;
    private String tranRefId;
    private Date tranDate;
    private String tranPoint;
    private BigDecimal tranAmt;
    private String custRefId;
    private String custPointUsed;
    private String custPointBalance;
    private String rewCode;
    private String accType;
    private String accValue;
    private String trueCardNo;
    private String cardHolderName;
    private String trueCardType;
    private String trueCardStatus;
    private String trueCardExpired;
    private String pointBalance;
    private String pointPackDesc;
    private BigDecimal pointPackBalance;
    private String pointPackExpired;
    private String sliptypeId;
    private String sliptypeDesc;
    private String tranType;
    private String payTracId;
    private String payBatId;
    private String payTranRefId;
    private Date payTranDate;
    private BigDecimal payAmt;
    private String payCurr;
    private String payCode;
    private String payMethod;
    private String campName;
    private String contCampCode;
    private String contCampName;
    private String contCampImgUrl;
    private String contCampStart;
    private String contCampEnd;
    private String contCampLastModified;
    private String contCampStatus;
    private String pointStr;
    private String resData;
    private String resStatus;
    private Date reqDatetime;
    private Integer reqTimeDiff;

}
