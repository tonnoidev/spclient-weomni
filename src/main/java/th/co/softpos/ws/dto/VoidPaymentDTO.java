package th.co.softpos.ws.dto;

import th.co.softpos.ws.model.Campaign;
import th.co.softpos.ws.model.Account;
import th.co.softpos.ws.model.Payment;

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

transactionType	string
example: POINT_CANCEL
Transaction Type (ประเภท Transaction)
POINT_EARN,
POINT_CANCEL,
REDEEM_BENEFIT,
REDEEM_MARKUSE,
REDEEM_ROLLBACK,
PAYMENT_CHARGE,
PAYMENT_CANCEL,
PAYMENT_REFUND

Enum:
Array [ 8 ]
payment	{
traceId	string
example: 000001
Transaction Trace ID
(รหัสสำหรับติดตามการซื้อขาย)

batchId	string
example: 000076
Transaction Batch ID

transactionReferenceId	string
example: 2018041015543027
Terminal/POS Transaction ID
(จุดติดตั้ง/รหัส POS Transaction)

transactionDate	string
example: 2018-04-10T15:54:30.326
Transaction Date
(วันที่ทำ Transaction)

amount	string
example: 100
Amount of money in satang for earning point
(จำนวนเงินหน่วยสตางค์สำหรับ earn point)

currency	string
example: THB
Currency (support THB only)
สกุลเงิน (สนับสนุนแต่ไทยบาทเท่านั้น)

code	string
example: 00002108051364
Bar code from Alipay/Wallet
(บาร์โค้ดจาก Alipay/Wallet)

method	string
example: WALLET
Payment method (วิธีการจ่ายเงิน)
ALIPAY
WALLET

}
account	{
type	string
example: TRUECARD
Account Type
(ประเภท Account)
THAIID - Thai Identity ID (รหัสบัตรประชาชน)
TRUECARD - True Card (ทรูการ์ด)
MOBILE - Mobile phone number (หมายเลขโทรศัพท์)

value	string
example: 8881408882765089
Value of account according to account type
(เลขของ Account แต่ละประเภท)

}
trueYouId	string
example: 101110000100006
TrueYou Merchant ID
(รหัสร้านค้าทรูยู)

campaign	{
name	string
example:
Campaign Name of Void Redeem
(ชื่อ campaign ที่ยกเลิกการ Redeem)

}
point	string
Number of point void
(จำนวน point ที่่ยกเลิก)
 */
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTrueYouId() {
        return trueYouId;
    }

    public void setTrueYouId(String trueYouId) {
        this.trueYouId = trueYouId;
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
        return "VoidPaymentDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", terminalId=" + terminalId + ", transactionType=" + transactionType + ", payment=" + payment + ", account=" + account + ", trueYouId=" + trueYouId + ", campaign=" + campaign + ", point=" + point + '}';
    }

}
