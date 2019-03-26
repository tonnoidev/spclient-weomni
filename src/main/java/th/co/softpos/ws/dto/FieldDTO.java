package th.co.softpos.ws.dto;

/*
name	string
example: fieldName
Error Request Field
(ชื่อตัวแปรที่ Error)

message	string
example: Error message for fieldName
Request Field Error Message
(ข้อความ Error ของตัวแปร)
 */
public class FieldDTO {

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FieldDTO{" + "name=" + name + ", message=" + message + '}';
    }

}
