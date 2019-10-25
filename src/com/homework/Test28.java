/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

/**
 *                       
 * @Filename: Test25.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test28 {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        Test28 test = new Test28();
        System.out.println(test.strStr("hello", "ll"));
    }
    
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        
        return haystack.indexOf(needle);
    }
}
