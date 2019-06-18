package com.homework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test13 {

	public static void main(String[] args) {
	    Map<String, String> map = new LinkedHashMap<>();
	    map.put("4", "ppp4");
	    map.put("0", "ppp");
	    map.put("1", "ppp1");
	    map.put("2", "ppp2");
	    map.put("3", "ppp3");
	    System.out.println(map.get(map.keySet().iterator().next()));
	    System.out.println(JSONObject.toJSONString(null));
	    Integer a = null;
	    System.out.println(a == 2);
	}
	
	private static int romanCharToInt(char ch) {
		int d = 0;
		switch (ch) {
		case 'I':
			d = 1;
			break;
		case 'V':
			d = 5;
			break;
		case 'X':
			d = 10;
			break;
		case 'L':
			d = 50;
			break;
		case 'C':
			d = 100;
			break;
		case 'D':
			d = 500;
			break;
		case 'M':
			d = 1000;
			break;
		}
		return d;
	}

	private static int romanToInt(String s) {
		if (s.length() <= 0)
			return 0;
		int result = romanCharToInt(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int prev = romanCharToInt(s.charAt(i - 1));
			int curr = romanCharToInt(s.charAt(i));
			// if left<right such as : IV(4), XL(40), IX(9) ...
			if (prev < curr) {
				result = result - prev + (curr - prev);
			} else {
				result += curr;
			}
		}
		return result;
	}
}
