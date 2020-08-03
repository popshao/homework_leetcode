/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *                       
 * @Filename: Test25.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test30 {

    public static void main(String[] args) {
        Test30 test = new Test30();
        String s = "barfoofoobarthefoobarman";
        String[] words = new String[] {"bar","foo", "the"};
        System.out.println(test.findSubstring(s, words));
    }
    
    private static Stack<String> stack = new Stack<>();
    private static List<String> list = new ArrayList<>();
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        this.aclStr(words, 0);
        for(int i = 0; i < list.size(); i++) {
            int index = (s.length() - s.replace(list.get(i), "").length()) / list.get(i).length();
            int startIndex = 0;
            for (int j = 0; j < index; j++) {
                startIndex = s.indexOf(list.get(i), startIndex);
                result.add(startIndex);
            }
        }
        
        return result;
    }
    
    private void aclStr(String[] strs, int n) {
        if (n == strs.length) {
            String result = "";
            for (String temp : stack) {
                result += temp;
            }
            list.add(result);
            return;
        }
        
        for (int i = 0; i < strs.length; i++) {
            if (!stack.contains(strs[i])) {
                stack.add(strs[i]);
                aclStr(strs, n + 1);
                stack.pop();
            }
        }
    }
    
}
