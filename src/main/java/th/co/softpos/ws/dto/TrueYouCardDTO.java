package th.co.softpos.ws.dto;

import com.google.gson.annotations.SerializedName;
import th.co.softpos.ws.model.Point;
import th.co.softpos.ws.model.SlipType;

/*
false	string
example: 8891518890714183
True Card Number
(หมายเลขทรูการ์ด)

name	string
example: Jonh
Cardholder Name
(ชื่อผู้ถือบัตร)

type	string
example: BLACK
True Card Type
(ประเภททรูการ์ด)

status	string
example: A
Status of True Card
(สถานะทรูการ์ด)

expired	string
example: 12/20
Card Expire Month and Year
(วันหมดอายุบัตร เดือนและปี)

point	{
balance	number
example: 89630
Points Balance
(Point ที่คงเหลือ)

pockets	[{
description	string
example: Point between 25092017 00:00:00 to 31/12/2018 23:59:59
Point Description
(รายละเอียด Point)

balance	number
example: 89630
Points Balance
(Point ที่คงเหลือ)

expired	string
example: 2020-12-31
Point Expire Date
(วันที่ Point หมดอายุ)

}]
}
slipType	{
id	string
example: You are True
Slip Type (ประเภทสลิป)
1 = Normal Customer (who not buy True product/service) (ลูกค้าทั่วไป ซึ่งอาจจะไม่ใช่ลูกค้าทรู)
2 = True Customer (without card) (ลูกค้าทรูที่ไม่มีบัตร)
3 = True Customer (card not expire) (ลูกค้าทรูที่บัตรยังไม่หมดอายุ)
4 = True Customer (card expired or has not brought any True product/service) (ลูกค้าทรูที่บัตรหมดอายุแล้ว หรือไม่ได้มีการซื้อสินค้าหรือบริการของทรูเลย)
5 = Other (อื่นๆ)

Enum:
Array [ 5 ]
description	string
Slip Type Description (in english) (ประเภทสลิป แบบภาษาอังกฤษ)

}
 */
public class TrueYouCardDTO {

    @SerializedName("false")
    private String falses;
    private String name;
    private String type;
    private String status;
    private String expired;
    private Point point;
    private SlipType slipType;

    public String getFalses() {
        return falses;
    }

    public void setFalses(String falses) {
        this.falses = falses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public SlipType getSlipType() {
        return slipType;
    }

    public void setSlipType(SlipType slipType) {
        this.slipType = slipType;
    }

    @Override
    public String toString() {
        return "TrueYouCardDTO{" + "False=" + falses + ", name=" + name + ", type=" + type + ", status=" + status + ", expired=" + expired + ", point=" + point + ", slipType=" + slipType + '}';
    }

}
