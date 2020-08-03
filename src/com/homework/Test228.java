/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.sun.org.omg.CORBA.AttrDescriptionSeqHelper;

/**
 *                       
 * @Filename: Test722.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test228 {

    public static void main(String[] args) {
        int[] attr = {0,1,2,4,5,7};
        
        Test228 test = new Test228();
        System.out.println(JSON.toJSONString(test.summaryRanges(attr)));;
    }
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        String startIndex = "";
        String endIndex = "";
        for (int i = 0; i < nums.length; i++) {
            startIndex = String.valueOf(nums[i]);
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            endIndex = String.valueOf(nums[i]);
            if (startIndex.equals(endIndex)) {
                result.add(startIndex);
            } else {
                result.add(startIndex + "->" + endIndex);
            }
        }
        
        return result;
    }
}
