package th.co.softpos.ws.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
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

}
