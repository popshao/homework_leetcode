/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

/**
 *                       
 * @Filename: Test35.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test35 {

    public static void main(String[] args) {
        
    }
    
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        
        return nums.length;
    }
}
