package com.homework.util;

public class BoardingCardVO {

    /**
     * 会议详情
     */
    private String meeting_detail;
    
    private BaseCartVO base_info = new BaseCartVO();

    public String getMeeting_detail() {
        return meeting_detail;
    }

    public void setMeeting_detail(String meeting_detail) {
        this.meeting_detail = meeting_detail;
    }

    public BaseCartVO getBase_info() {
        return base_info;
    }

    public void setBase_info(BaseCartVO base_info) {
        this.base_info = base_info;
    }
    
}
