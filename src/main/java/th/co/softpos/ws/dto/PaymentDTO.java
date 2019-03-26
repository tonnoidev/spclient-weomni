package th.co.softpos.ws.dto;

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

payment	{
traceId	string
example: 000014
Transaction Trace ID
(รหัสสำหรับติดตามการซื้อขาย)

batchId	string
example: 000035
Transaction Batch ID

transactionReferenceId	string
example: 2017112817543357
Terminal/POS Transaction ID
(จุดติดตั้ง/รหัส POS Transaction)

transactionDate	string
example: 2017-11-28T17:54:33.55
Transaction Date
(วันที่ทำ Transaction)

currency	string
example: THB
Currency (support THB only)
สกุลเงิน (สนับสนุนแต่ไทยบาทเท่านั้น)

amount	string
example: 100
Amount of money in satang for earning point
(จำนวนเงินหน่วยสตางค์สำหรับ earn point)

code	string
example: 00002108051364
Bar code from Alipay/Wallet
(บาร์โค้ดจาก Alipay/Wallet)

method	string
example: WALLET
Payment method (วิธีการจ่ายเงิน)
ALIPAY
WALLET

Enum:
Array [ 2 ]
}
trueYouId	string
example: 101110000100006
TrueYou Merchant ID
(รหัสร้านค้าทรูยู)
 */
public class PaymentDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Payment payment;
    private String trueYouId;

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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getTrueYouId() {
        return trueYouId;
    }

    public void setTrueYouId(String trueYouId) {
        this.trueYouId = trueYouId;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", terminalId=" + terminalId + ", payment=" + payment + ", trueYouId=" + trueYouId + '}';
    }

}
