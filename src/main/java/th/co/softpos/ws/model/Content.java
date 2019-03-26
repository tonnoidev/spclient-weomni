package th.co.softpos.ws.model;

public class Content {

    private String brandId;
    private String branchId;
    private String terminalId;
    private Campaign campaign;

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

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @Override
    public String toString() {
        return "Content{" + "brandId=" + brandId + ", branchId=" + branchId + ", terminalId=" + terminalId + ", campaign=" + campaign + '}';
    }

}
