package th.co.softpos.ws.dto;

import java.io.Serializable;

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
Terminal/Device ID
(จุดติดตั้ง/รหัสอุปกรณ์)

serialNumner	string
example: 869826022379141
Device Serial Number
(หมายเลข Serial ของอุปกรณ์)

activationCode	string
example: 99999999
Activation Code
(รหัสเปิดใช้งาน)
 */
public class ActivateDTO implements Serializable {

    private String brandId;
    private String branchId;
    private String terminalId;
    private String serialNumner;
    private String activationCode;

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

    public String getSerialNumner() {
        return serialNumner;
    }

    public void setSerialNumner(String serialNumner) {
        this.serialNumner = serialNumner;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public String toString() {
        return "ActivateDTO{" + "brandId=" + brandId + ", branchId=" + branchId + ", terminalId=" + terminalId + ", serialNumner=" + serialNumner + ", activationCode=" + activationCode + '}';
    }

}
