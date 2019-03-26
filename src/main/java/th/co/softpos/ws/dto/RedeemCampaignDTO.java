package th.co.softpos.ws.dto;

import th.co.softpos.ws.model.Transaction;
import th.co.softpos.ws.model.Customer;

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

trueYouId	string
example: 101110000100006
TrueYou Merchant ID
(รหัสร้านค้าทรูยู)

transaction	{
traceId	string
example: 000010
Transaction Trace ID
(รหัสสำหรับติดตามการซื้อขาย)

batchId	string
example: 000075
Transaction Batch ID

transactionReferenceId	string
example: 2018041012363672
Terminal/POS Transaction ID
(จุดติดตั้ง/รหัส POS Transaction)

transactionDate	string
example: 2018-04-10T12:36:36.724
Transaction Date
(วันที่ทำ Transaction)

}
customer	{
customerReferenceId	string
example: 2000000000108
Customer’s True card number
(หมายเลขทรูการ์ดของลูกค้า)

pointUsed	string
example: 0
Points use by redeem
(Point ที่ใช้ redeem)

pointBalance	string
example: 450
Balance points
(Point ที่มีอยู่)

}
*/

public class RedeemCampaignDTO {

    private String brandId;
    private String branchId;
    private String terminalId;
    private String trueYouId;
    private Transaction transaction;
    private Customer customer;

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

    public String getTrueYouId() {
        return trueYouId;
    }

    public void setTrueYouId(String trueYouId) {
        this.trueYouId = trueYouId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "RedeemCampaignDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", terminalId=" + terminalId + ", trueYouId=" + trueYouId + ", transaction=" + transaction + ", customer=" + customer + '}';
    }
    
}
