package th.co.softpos.ws.model;

import java.util.List;
import lombok.Data;

@Data
public class Point {

    private Integer balance;
    private List<Pockets> pockets;

}
