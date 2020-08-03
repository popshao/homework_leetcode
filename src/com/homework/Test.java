package com.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.homework.entity.OnoteDataVo;

public class Test {

    static List<String> todoList = new ArrayList<>();
    static Map<String, List<String>> forList = new HashMap<>();
    
	public static void main(String[] args) throws ParseException {
	    List<String> list = new ArrayList<>();
	    list.add("18627085405");
	    list.add("15072448559");
	    System.out.println(list.hashCode());
	    
	}
	
	public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16杩涘埗parse鏁村舰瀛楃涓层�
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
}
