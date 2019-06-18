package com.homework.youyaku;

import java.io.IOException;
import java.util.TimerTask;

public class Task extends TimerTask {

    private CourseVO selectCourseVO;
    private String   accessToken;
    
    public Task() {}
    
    public Task(String accessToken, CourseVO selectCourseVO) {
        this.accessToken = accessToken;
        this.selectCourseVO = selectCourseVO;
    }
    
    @Override
    public void run() {
        WeixinUtil util = new WeixinUtil();
        Boolean flag = false;
        System.out.println("开始执行定时任务...");
        int count = 1;
        while (true) {
            if (count > 6 || flag) {
                break;
            }
            if (count > 2) {
                try {
                    // 10秒预约一次
                    Thread.sleep(1000 * 20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("进行第" + count + "次预约");
            try {
                flag = util.checkCourse(accessToken, selectCourseVO.getSchedule_id());
            } catch (Exception e) {
                System.out.println("第" + count + "次预约异常，结果：" + flag);
                count++;
                continue;
            }
            System.out.println("第" + count + "次预约结束，结果：" + flag);
            count++;
        }
        
        if (flag) {
            System.out.println("预约成功！");
        } else {
            System.out.println("预约失败！");
        }
        
        try {
            java.lang.Runtime.getRuntime().exec("rundll32.exe powrProf.dll,SetSuspendState");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

}
