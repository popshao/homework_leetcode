package com.homework.youyaku;

import com.alibaba.fastjson.JSONObject;


/**
 * 微信服务接口
 * 
 * @Author: lei.zhang
 * @Email: lei.zhang@rograndec.com
 * @CreateDate: 2019/5/17
 * @Version: 1.0
 */
public class CourseVO {
    
    private String coach_name;
    
    private String schedule_id;
    
    private String start_time;
    
    private String end_time;

    public String getCoach_name() {
        return coach_name;
    }

    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    
}
