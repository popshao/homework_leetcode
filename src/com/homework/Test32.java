/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

import com.alibaba.fastjson.JSON;

/**
 *                       
 * @Filename: Test32.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test32 {
    public static void main(String[] args) {
        Test32 test = new Test32();
        System.out.println(JSON.toJSONString(test.longestValidParentheses("(()")));
    }
    
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            
        }
        
        return 0;
    }
}
