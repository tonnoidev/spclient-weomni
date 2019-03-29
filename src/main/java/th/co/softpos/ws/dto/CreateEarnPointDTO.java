package th.co.softpos.ws.dto;

import th.co.softpos.ws.model.Account;

/*
brandId*	string
example: 1100001
Brand/Merchant ID
(แบรนด์/รหัสร้านค้า)

branchId*	string
example: 00006
Branch ID
(รหัสสาขา)

account	{
description:	
Brand/Merchant ID
(แบรนด์/รหัสร้านค้า)

type*	string
example: THAIID
Account Type
(ประเภท Account)
THAIID - Thai Identity ID(รหัสบัตรประชาชน)
TRUECARD - True Card(ทรูการ์ด)
MOBILE - Mobile phone number(หมายเลขโทรศัพท์)

value*	string
example: 2000000000104
Value of account according to account type
(เลขของ Account แต่ละประเภท)

}
amount*	number
example: 10000
Amount of money in satang for earning point
(จำนวนเงินหน่วยสตางค์สำหรับ earn point)

external	boolean
example: false
Map external ids
ต้องการใช้ external ids
 */
public class CreateEarnPointDTO {

    private String brandId;
    private String branchId;
    private Account account;
    private Integer amount;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    @Override
    public String toString() {
        return "CreateEarnPointDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", account=" + account + ", amount=" + amount + ", external=" + external + '}';
    }

}
