package com.homework.interfaceTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimeEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("do something..." + new Date());
    }

}
