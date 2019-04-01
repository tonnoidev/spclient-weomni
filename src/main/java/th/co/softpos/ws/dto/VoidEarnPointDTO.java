package th.co.softpos.ws.dto;

import th.co.softpos.ws.model.Account;
import th.co.softpos.ws.model.Campaign;
import th.co.softpos.ws.model.Payment;
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
example: 000021
Transaction Trace ID
(รหัสสำหรับติดตามการซื้อขาย)

batchId	string
example: 000075
Transaction Batch ID

transactionReferenceId	string
example: 2018041015543027
Terminal/POS Transaction ID
(จุดติดตั้ง/รหัส POS Transaction)

transactionDate	string
example: 2018-04-10T15:54:30.326
Transaction Date
(วันที่ทำ Transaction)

points	number
example: 4
Earned point
(รับ Point)

amount	number
example: 10000
Amount of money in satang for earning point
(จำนวนเงินหน่วยสตางค์สำหรับ earn point)

}
trueYouId	string
example: 101110000100006
TrueYou Merchant ID
(รหัสร้านค้าทรูยู)

account	{
type	string
example: THAIID
Account Type
(ประเภท Account)
THAIID - Thai Identity ID (รหัสบัตรประชาชน)
TRUECARD - True Card (ทรูการ์ด)
MOBILE - Mobile phone number (หมายเลขโทรศัพท์)

value	string
example: 2000000000104
Value of account according to account type
(เลขของ Account แต่ละประเภท)

}
 */
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "EarnPointDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", terminalId=" + terminalId + ", transaction=" + transaction + ", trueYouId=" + trueYouId + ", account=" + account + '}';
    }

}
