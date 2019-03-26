package th.co.softpos.ws.dto;

/*
code	string
example: XXX
Error Code
(Error โค๊ด)

displayCode	string
example: YYY
Error Code for display
(Error โค๊ด)

messsage	string
example: error message will display here.
Error Message
(ข้อความ Error)

fields	[FieldDTO{
name	string
example: fieldName
Error Request Field
(ชื่อตัวแปรที่ Error)

message	string
example: Error message for fieldName
Request Field Error Message
(ข้อความ Error ของตัวแปร)

}]
 */
public class ErrorDTO {

    private String code;
    private String displayCode;
    private String messsage;
    private FieldDTO []fields;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayCode() {
        return displayCode;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public FieldDTO[] getFields() {
        return fields;
    }

    public void setFields(FieldDTO[] fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        String data = "ErrorDTO{" + "code=" + code + ", displayCode=" + displayCode + ", messsage=" + messsage + "field:\n";
        for (FieldDTO field : fields) {
            data += field + "\n";
        }
        data += "}";
        
        return data;
    }

}
