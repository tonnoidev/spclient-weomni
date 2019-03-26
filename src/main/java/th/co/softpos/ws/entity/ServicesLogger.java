package th.co.softpos.ws.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ServicesLogger implements Serializable {

    @Id
    private int id;
    @Column
    private String uri;
    @Column
    private String method;
    @Column
    private String msg_request;
    @Column
    private String msg_response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMsg_request() {
        return msg_request;
    }

    public void setMsg_request(String msg_request) {
        this.msg_request = msg_request;
    }

    public String getMsg_response() {
        return msg_response;
    }

    public void setMsg_response(String msg_response) {
        this.msg_response = msg_response;
    }

    @Override
    public String toString() {
        return "ServicesLogger{" + "id=" + id + ", uri=" + uri + ", method=" + method + ", msg_request=" + msg_request + ", msg_response=" + msg_response + '}';
    }

}
