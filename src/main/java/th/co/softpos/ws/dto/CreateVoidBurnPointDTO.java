package th.co.softpos.ws.dto;

import lombok.Data;

@Data
public class CreateVoidBurnPointDTO {

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
