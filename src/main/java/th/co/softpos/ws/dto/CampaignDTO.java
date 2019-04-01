package th.co.softpos.ws.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import th.co.softpos.ws.model.Page;
import th.co.softpos.ws.model.Content;

@Data
public class CampaignDTO implements Serializable {

    private List<Content> content;
    private Page page;

}
