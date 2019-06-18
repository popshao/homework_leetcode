package com.homework.util;

public class BaseCartVO {

    /**
     * 卡券的商户logo，建议像素为300*300。
     */
    private String     logo_url    = "http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFNjakmxibMLGWpXrEXB33367o7zHN0CwngnQY7zb7g/0";

    /**
    * Code展示类型 "CODE_TYPE_TEXT"，
    * 文本； "CODE_TYPE_BARCODE"，
    * 一维码 ； "CODE_TYPE_QRCODE"，
    * 二维码； "CODE_TYPE_ONLY_QRCODE",
    * 二维码无code显示； "CODE_TYPE_ONLY_BARCODE",
    * 一维码无code显示；
    */
    private String     code_type   = "CODE_TYPE_QRCODE";

    /**
    * 商户名字,字数上限为12个汉字。
    */
    private String     brand_name  = "xx公司";

    /**
    * 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
    */
    private String     title       = "xx会议门票";

    /**
    * 发券颜色 按色彩规范标注填写Color010-Color100。
    */
    private String     color       = "Color010";

    /**
    * 卡券使用提醒，字数上限为16个汉字。
    */
    private String     notice      = "请出示二维码核销卡券";

    /**
    * 卡券使用说明，字数上限为1024个汉字。
    */
    private String     description = "不可与其他优惠同享/n如需团购券发票，请向店员提出要求。";

    /**
    * 商品信息
    */
    private SkuVO      sku = new SkuVO();

    /**
     * 自定义跳转
     */
    private String custom_url = "www.baidu.com";
    
    /**
    * 使用日期，有效期的信息
    */
    private DateInfoVO date_info = new DateInfoVO();

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SkuVO getSku() {
        return sku;
    }

    public void setSku(SkuVO sku) {
        this.sku = sku;
    }

    public DateInfoVO getDate_info() {
        return date_info;
    }

    public void setDate_info(DateInfoVO date_info) {
        this.date_info = date_info;
    }

    public String getCustom_url() {
        return custom_url;
    }

    public void setCustom_url(String custom_url) {
        this.custom_url = custom_url;
    }

}
