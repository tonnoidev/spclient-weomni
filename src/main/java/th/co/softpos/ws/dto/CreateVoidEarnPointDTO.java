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

external	boolean
example: false
Map external ids
ต้องการใช้ external ids
 */
public class CreateVoidEarnPointDTO {

    private String brandId;
    private String branchId;
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

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    @Override
    public String toString() {
        return "CreateEarnPointDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", external=" + external + '}';
    }

}
