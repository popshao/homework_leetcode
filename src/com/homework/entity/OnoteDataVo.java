package com.homework.entity;

import java.io.Serializable;
/**
 * @Author: chao.zhu
 * @description:
 * @CreateDate: 2019-04-30
 * @Version: 1.0
 */
public class OnoteDataVo implements Serializable {
    private static final long serialVersionUID = 3030520435357465545L;
    /**
     * vip类型：
     * 1：VIP
     * 2：SVIP（已废弃）
     * 3：过期续费
     * 4：未过期续费
     * 5：赠送VIP
     */
    private Integer type;
    /**
     * 推荐人手机号
     */
    private String phone;
    /**
     * 省
     */
    private Integer province;
    /**
     * 市
     */
    private Integer city;
    /**
     * 区
     */
    private Integer region;
    /**
     * VIP来源
     */
    private String source;
    /**
     * VIP时长类型：
     * 3个月
     * 6个月
     * 1年
     */
    private Integer expire;
    /**
     * 增删VIP类型
     * 0：不赠送
     * 1：非VIP够买赠送
     * 2：vip够买赠送
     */
    private Integer giveVipType;
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getProvince() {
        return province;
    }
    public void setProvince(Integer province) {
        this.province = province;
    }
    public Integer getCity() {
        return city;
    }
    public void setCity(Integer city) {
        this.city = city;
    }
    public Integer getRegion() {
        return region;
    }
    public void setRegion(Integer region) {
        this.region = region;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Integer getExpire() {
        return expire;
    }
    public void setExpire(Integer expire) {
        this.expire = expire;
    }
    public Integer getGiveVipType() {
        return giveVipType;
    }
    public void setGiveVipType(Integer giveVipType) {
        this.giveVipType = giveVipType;
    }
    public OnoteDataVo() {
    }
    public OnoteDataVo(Integer type, String phone, Integer province, Integer city, Integer region, String source, Integer expire) {
        this.type = type;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.region = region;
        this.source = source;
        this.expire = expire;
    }
//    public static void main(String[] args) {
//        OnoteDataVo vo = new OnoteDataVo(1,"13200000000",1,2,3,"mypharma",12);
//        vo.setGiveVipType(1);
//        System.out.println(JSON.toJSONString(vo));
//    }
}
