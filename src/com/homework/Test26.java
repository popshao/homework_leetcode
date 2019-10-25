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
public class Test26 {

    public static void main(String[] args) {
        
    }
    
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
