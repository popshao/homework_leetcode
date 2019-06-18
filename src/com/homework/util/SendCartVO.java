package com.homework.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendCartVO {

    private List<String> touser;

    private Map<String, String>       wxcard = new HashMap<>();

    private String msgtype = "wxcard";
    
    public List<String> getTouser() {
        return touser;
    }

    public void setTouser(List<String> touser) {
        this.touser = touser;
    }

    public Map<String, String> getWxcard() {
        return wxcard;
    }

    public void setWxcard(Map<String, String> wxcard) {
        this.wxcard = wxcard;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    
    public void setCardId(String cardId) {
        wxcard.put("card_id", cardId);
    }
}
