package th.co.softpos.ws.dto;

import th.co.softpos.ws.model.Payment;

/*
brandId*	string
example: 1100001
Brand/Merchant ID
(แบรนด์/รหัสร้านค้า)

branchId*	string
example: 00006
Branch ID
(รหัสสาขา)

payment*	{
amount*	string
example: 100
Amount of money in satang
100 satang = 1 baht
(จำนวนหน่วยของเงินแบบสตางค์ 100 สตางค์ = 1 บาท)

currency*	string
example: THB
Currency (support THB only)
สกุลเงิน (สนับสนุนแต่ไทยบาทเท่านั้น)

code*	string
example: 00002108051364
Bar code from Alipay/Wallet
(บาร์โค้ดจาก Alipay/Wallet)

method*	string
example: WALLET
Payment method (วิธีการจ่ายเงิน)
ALIPAY
WALLET

Enum:
[ WALLET, ALIPAY ]
description	string
example:
Description
(ลักษณะ)

}
external	boolean
example: false
Map external ids
ต้องการใช้ external ids
 */
public class CreatePaymentDTO {

    private String brandId;
    private String branchId;
    private Payment payment;
    private Boolean external;

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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    @Override
    public String toString() {
        return "CreatePaymentDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", payment=" + payment + ", external=" + external + '}';
    }

}
