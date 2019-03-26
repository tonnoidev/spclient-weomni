package th.co.softpos.ws.dto;

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
example: TEST-4051
Campaign Code
(รหัสแคมเปญ)

rewardCode*	string
example: TY75270373
Customer’s reward code
(รหัสให้รางวัลลูกค้า)

external	boolean
example: false
Map external ids
ต้องการใช้ external ids
 */
public class CreateRedeemCodeDTO {

    private String brandId;
    private String branchId;
    private String campaignCode;
    private String rewardCode;
    private String external;

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

    public String getRewardCode() {
        return rewardCode;
    }

    public void setRewardCode(String rewardCode) {
        this.rewardCode = rewardCode;
    }

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external;
    }

    @Override
    public String toString() {
        return "CreateRedeemCodeDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", campaignCode=" + campaignCode + ", rewardCode=" + rewardCode + ", external=" + external + '}';
    }

}
