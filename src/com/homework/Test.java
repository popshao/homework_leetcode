package com.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;

public class Test {

    static List<String> todoList = new ArrayList<>();
    static Map<String, List<String>> forList = new HashMap<>();
    
	public static void main(String[] args) {
		String test = "NaN";
		try {
		    Integer a = Integer.parseInt(test);
		    System.out.println(1);
		} catch (NumberFormatException e) {
            System.out.println(2);
        }
	    
	}
}
