package com.homework.util;

import com.sun.jmx.snmp.Timestamp;

public class DateInfoVO {

    /**
    * 使用时间的类型，仅支持填写1或2。1为固定日期区间，2为固定时长（自领取后按天算）。
    */
    private Integer type = 2;

    /**
    * type为1时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间(UTC+8)，单位为秒）
    */
    private Integer begin_timestamp;

    /**
    * type为1时专用，表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间 (UTC+8) ，单位为秒）
    */
    private Integer end_timestamp;

    /**
    * type为2时专用，表示自领取后多少天内有效，领取后当天有效填写0。（单位为天）
    */
    private Integer fixed_term = 30;

    /**
    * type为2时专用，表示自领取后多少天开始生效。（单位为天）
    */
    private Integer fixed_begin_term = 0;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBegin_timestamp() {
        return begin_timestamp;
    }

    public void setBegin_timestamp(Integer begin_timestamp) {
        this.begin_timestamp = begin_timestamp;
    }

    public Integer getEnd_timestamp() {
        return end_timestamp;
    }

    public void setEnd_timestamp(Integer end_timestamp) {
        this.end_timestamp = end_timestamp;
    }

    public Integer getFixed_term() {
        return fixed_term;
    }

    public void setFixed_term(Integer fixed_term) {
        this.fixed_term = fixed_term;
    }

    public Integer getFixed_begin_term() {
        return fixed_begin_term;
    }

    public void setFixed_begin_term(Integer fixed_begin_term) {
        this.fixed_begin_term = fixed_begin_term;
    }

}
