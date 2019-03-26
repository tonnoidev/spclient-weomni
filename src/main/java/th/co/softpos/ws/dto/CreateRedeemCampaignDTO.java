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

campaignCode*	string
example: TEST-6764
Campaign Code
(รหัสแคมเปญ)

account	{
type*	string
example: THAIID
Account Type
(ประเภท Account)
THAIID - Thai Identity ID (รหัสบัตรประชาชน)
TRUECARD - True Card (ทรูการ์ด)
MOBILE - Mobile phone number (หมายเลขโทรศัพท์)

value*	string
example: 2000000000108
Value of account according to account type
(เลขของ Account แต่ละประเภท)

}
external	boolean
example: false
Map external ids
ต้องการใช้ external ids
 */
public class CreateRedeemCampaignDTO {

    private String brandId;
    private String branchId;
    private String campaignCode;
    private Account account;
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

    public String getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    @Override
    public String toString() {
        return "CreateRedeemCampaignDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", campaignCode=" + campaignCode + ", account=" + account + ", external=" + external + '}';
    }

}
