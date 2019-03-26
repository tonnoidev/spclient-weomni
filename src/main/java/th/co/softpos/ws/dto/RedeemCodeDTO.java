package th.co.softpos.ws.dto;

import th.co.softpos.ws.model.Transaction;

/*
brandId	string
example: 1100001
Brand/Merchant ID
(แบรนด์/รหัสร้านค้า)

branchId	string
example: 00006
Branch ID
(รหัสสาขา)

terminalId	string
example: 69000006
Terminal ID
(รหัสจุดติดตั้ง)

transaction	{
traceId	string
example: 000019
Transaction Trace ID
(รหัสสำหรับติดตามการซื้อขาย)

batchId	string
example: 000075
Transaction Batch ID

transactionReferenceId	string
example: 2018041014443644
Terminal/POS Transaction ID
(จุดติดตั้ง/รหัส POS Transaction)

transactionDate	string
example: 2018-04-10T14:44:36.942
Transaction Date
(วันที่ทำ Transaction)

}
trueYouId	string
example: 101110000100006
TrueYou Merchant ID
(รหัสร้านค้าทรูยู)

rewardCode	string
example: TY75270373
Customer’s reward code
(รหัสให้รางวัลลูกค้า)
 */
public class RedeemCodeDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Transaction transaction;
    private String trueYouId;
    private String rewardCode;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getTrueYouId() {
        return trueYouId;
    }

    public void setTrueYouId(String trueYouId) {
        this.trueYouId = trueYouId;
    }

    public String getRewardCode() {
        return rewardCode;
    }

    public void setRewardCode(String rewardCode) {
        this.rewardCode = rewardCode;
    }

    @Override
    public String toString() {
        return "RedeemCodeDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", terminalId=" + terminalId + ", transaction=" + transaction + ", trueYouId=" + trueYouId + ", rewardCode=" + rewardCode + '}';
    }

}
