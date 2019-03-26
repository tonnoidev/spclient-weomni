package th.co.softpos.ws.dto;

import java.math.BigDecimal;

/*
activationCode*	string
example: 99999999
Activation Code after register store successfullly with TrueYou
(รหัสเปิดใช้งานหลังจากที่ร้านลงทะเบียนกับทรูยูสำเร็จ)

imei*	string
example: 869826022379141
EDC IMEI Code
(รหัส IMEI ของ EDC)

latitude*	number
example: 13.7645001
Store’s Latitude
(ละติจูดของร้าน)

longitude*	number
example: 100.5679174
Store’s Longitude
(ลองติจูดของร้าน)

password*	string
example: 2222
Device password
(พาสเวิร์ดของอุปกรณ์)

external	boolean
example: false
Map external ids
ต้องการใช้ external ids
 */
public class CreateActivateDTO {

    private String activationCode;
    private String imei;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String password;
    private Boolean external;

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    @Override
    public String toString() {
        return "CreateActivateDTO{" + "activationCode=" + activationCode + ", imei=" + imei + ", latitude=" + latitude + ", longitude=" + longitude + ", password=" + password + ", external=" + external + '}';
    }

}
