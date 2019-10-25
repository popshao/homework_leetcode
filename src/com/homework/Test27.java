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
public class Test27 {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        Test27 test = new Test27();
        System.out.println(test.removeElement(nums, 3));
    }
    
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
           
        return j;
    }
}
