package th.co.softpos.ws.dto;

import java.io.Serializable;
import java.util.List;
import th.co.softpos.ws.model.Page;
import th.co.softpos.ws.model.Content;

/*
content	[{
brandId	string
example: 1100001
Brand/Merchant ID
(แบรนด์/รหัสร้านค้า)

branchId	string
example: 00004
Branch ID
(รหัสสาขา)

terminalId	string
example: 69000004
Terminal/Device ID
(จุดติดตั้ง/รหัสอุปกรณ์)

campaign	{
description:	
Campaign Object
(แคมเปญ object)

code	string
example: TEST-6853
Campaign Code
(รหัสแคมเปญ)

name	string
example: RedCard ส่วนลด 5%
Campaign name
(ชื่อแคมเปญ)

imageUrl	string
example: https://firebasestorage.googleapis.com/v0/b/edc-app-45fea.appspot.com/o/EDC%20Android%2Fimages_1.png?alt=media&token=02bf4dd0-7354-41bf-837e-d9eced0657ac
Campaign image url
(URL ของรูปแคมเปญ)

start	string
example: 2017-01-16 00:00:00
Campaign start date
(วันเริ่มแคมเปญ)

end	string
example: 2017-01-24 00:00:00
Campaign end date
(วันสิ้นสุดแคมเปญ)

lastModifiedDate	string
example: 2017-01-17
Last Modified Date
(วันที่แก้ไขล่าสุด)

status	string
example: active
Campaign Status
active
(สถานะแคมเปญที่ใช้งานอยู่)

Enum:
Array [ 2 ]
}
}]
page	{
totalElements	string
example: 10
Total number of campaigns
(จำนวนแคมเปญทั้งหมด)

totalPages	string
example: 2
Total pages
(จำนวนหน้าทั้งหมด)

size	string
example: 15
Number of campaign per page
(จำนวนแคมเปญต่อหน้า)

hasNext	string
example: true
Has next page
(มีหน้าถัดไป)

hasPrevious	string
example: false
Has previous page
(มีหน้าก่อนหน้า)

}
 */
public class CampaignDTO implements Serializable {

    private List<Content> content;
    private Page page;

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "CampaignDTO{" + "content=" + content + ", page=" + page + '}';
    }

}
