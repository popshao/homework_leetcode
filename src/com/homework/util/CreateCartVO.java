package com.homework.util;

public class CreateCartVO {

    /**
     * 飞机票类型
     */
    private String card_type;
    
    private BoardingCardVO meeting_ticket;
    
    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public BoardingCardVO getMeeting_ticket() {
        return meeting_ticket;
    }

    public void setMeeting_ticket(BoardingCardVO meeting_ticket) {
        this.meeting_ticket = meeting_ticket;
    }

}
