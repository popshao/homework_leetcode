/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

/**
 *                       
 * @Filename: Test34.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test34 {

    public static void main(String[] args) {
        Test34 test = new Test34();
        test.searchRange(new int[] {1}, 1);
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1 && nums[0] == target) {
            return new int[] {0,0};
        }
        
        while (start <= end) {
            if (nums[start] == target) {
                result[0] = start;
            } else {
                start++;
            }
            if (nums[end] == target) {
                result[1] = end;
            } else {
                end--;
            }
            
            if (result[0] != -1 && result[1] != -1)
                break;
        }
        
        return result;
    }
}
