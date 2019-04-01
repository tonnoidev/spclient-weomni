package th.co.softpos.ws.model;

import lombok.Data;

@Data
public class Page {

    private String totalElements;
    private String totalPages;
    private String size;
    private String hasNext;
    private String hasPrevious;

}
