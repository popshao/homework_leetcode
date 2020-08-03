/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename: Test722.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test415 {

    public static void main(String[] args) {
        Test415 test = new Test415();
        System.out.println(JSON.toJSONString(test.addStrings("10", "100")));;
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || "".equals(num1) || num2 == null || "".equals(num2)) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            result.append(carry % 10);
            carry = carry / 10;
        }

        return result.reverse().toString();
    }
}
