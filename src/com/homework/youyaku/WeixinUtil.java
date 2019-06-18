package com.homework.youyaku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.accessibility.AccessibleStateSet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.util.StringUtils;


/**
 * 微信服务接口
 * 
 * @Author: lei.zhang
 * @Email: lei.zhang@rograndec.com
 * @CreateDate: 2019/5/17
 * @Version: 1.0
 */
public class WeixinUtil {

    // 微信公众账号或开放平台服务号APP的唯一标识
    private final static String SERVICE_APP_ID = "wx7eee2d9c000854bd";

    // APPID服务号对应的接口密码
    private final static String SERVICE_APP_SECRET = "4940e367dfc12ee1e629b27bdd0f942a7f9be579";

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        System.out.println("正在读取初始化数据请稍等...");
        justSleep(500);
        InputStream inputStream = new FileInputStream("sys.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            System.out.println("配置文件初始化异常:" + e1.getMessage());
        }

        String accessToken = p.getProperty("accsess_token");
        String dateStr = p.getProperty("date");
        System.out.println("access_token:" + accessToken);
        System.out.println("date:" + dateStr);
        if (accessToken == null || accessToken.equals("")) {
            System.out.println("访问token不能为空，请填写后重启应用程序");
            return;
        }

        if (dateStr == null || dateStr.equals("")) {
            System.out.println("约课日期不能为空，请填写后重启应用程序");
            return;
        }
        String date = null;
        try {
            date = sdf2.format(sdf.parse(dateStr));
        } catch (ParseException e) {
            System.out.println("日期格式输入错误，按任意键退出");
            Scanner sc1 = new Scanner(System.in);
            String select = sc1.nextLine();
            if (select != null) {
                return;
            }
        }

        System.out.println("正在读取课表信息请稍等...");
        justSleep(500);
        WeixinUtil util = new WeixinUtil();

        List<CourseVO> courseList = util.getCourseList(accessToken, date);

        System.out.println("请选择约课信息：");
        Map<Integer, CourseVO> map = new HashMap<>();
        for (int i = 0; i < courseList.size(); i++) {
            int no = i + 1;
            System.out.println(no + ") " + courseList.get(i).getCoach_name() + " " + courseList.get(i).getStart_time()
                               + "~" + courseList.get(i).getEnd_time());
            map.put(no, courseList.get(i));
        }
        System.out.println("提示：输入ID选择课程：");
        Scanner sc = new Scanner(System.in);
        String select = sc.nextLine();
        CourseVO selectCourseVO = map.get(Integer.valueOf(select));
        if (selectCourseVO == null) {
            System.out.println("没有找到课程信息，请重新选择");
        }

        System.out.println("请确认课程信息...");
        System.out.println("课程名：" + selectCourseVO.getCoach_name());
        System.out.println("课程开始时间：" + selectCourseVO.getStart_time());
        System.out.println("课程结束时间：" + selectCourseVO.getEnd_time());

        System.out.println("按Y/y确认，按其他任意键返回.");
        sc = new Scanner(System.in);
        String returnStr = sc.nextLine();

        if (!"y".equals(returnStr) && !"Y".equals(returnStr)) {
            return;
        }
        Date checkDate = getTomorrow();
        System.out.println("正在预约" + sdf3.format(checkDate) + "的" + selectCourseVO.getCoach_name() + ", 请耐心等待...");
        Timer timer = new Timer();
        Task task = new Task(accessToken, selectCourseVO);
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。  
        timer.schedule(task, checkDate);
    }
    
    private static Date getTomorrow() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        calendar.set(calendar.HOUR_OF_DAY, 0);
        calendar.set(calendar.MINUTE, 0);
        calendar.set(calendar.SECOND, 0);
        return calendar.getTime();
    }
    
    public List<CourseVO> getCourseList(String accessToken, String date) {
        
        String param = "access_token=" + accessToken + "&brand_id=29639&venue_id=1&date_str=" + date + "&version=6.6.0&os=wx";
        String responseJson = HttpsClientUtil.sendPost("https://vcloud.keepyoga.com/course/api/wxccourselist", param);
        JSONObject jsonObject = JSON.parseObject(responseJson);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray jsonArray = data.getJSONArray("list");
        List<CourseVO> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            CourseVO vo = new CourseVO();
            vo.setSchedule_id(jsonArray.getJSONObject(i).getString("schedule_id"));
            vo.setCoach_name(jsonArray.getJSONObject(i).getString("course_name"));
            vo.setStart_time(jsonArray.getJSONObject(i).getString("start"));
            vo.setEnd_time(jsonArray.getJSONObject(i).getString("end"));
            
            result.add(vo);
        }
        
        return result;
    }
    
    private static void justSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    /*
     * 获取调用接口凭证access_token
     * 
     * @return access_token
     */
    public Boolean checkCourse(String accessToken, String courseId) throws Exception {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append("https://vcloud.keepyoga.com/course/api/wxcreservationcheckwithleague");
        String param = "access_token=" + accessToken
                       + "&brand_id=29639&venue_id=1&m_card_id=129&number=1&remark=&schedule_id=" + courseId
                       + "&version=6.6.0&os=wx";
        String responseJson = HttpsClientUtil.sendPost(requestUrl.toString(), param);
        responseJson = HttpsClientUtil.sendPost("https://vcloud.keepyoga.com/course/api/wxcaddreservationwithleague",
            param);
        JSONObject jsonObject = JSON.parseObject(responseJson);
        if (jsonObject.getString("error").equals("ok")) {
            return true;
        }
        
        return false;
    }

}
