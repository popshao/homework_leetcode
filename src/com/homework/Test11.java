package com.homework;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.homework.entity.ClassA;

public class Test11 {

	public static void main(String[] args) throws Exception {
		deepCopy();
	}
	
	public static <T> T deepCopy() throws Exception {
	    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement e : stackTrace) {
            if (e.getClassName().equals("com.homework.Test11")) {
                System.out.println(e.getClassName() + "\t"
                        + e.getMethodName() + "\t" + e.getLineNumber());
                return null;
            }
        }
        return null;
    }
	
	public int maxArea(int[] height) {

		int leftIndex = 0;
		int rightIndex = height.length;

		int maxArea = 0;
		int area = 0;

		while (leftIndex < rightIndex) {

			int leftHight = height[leftIndex];
			int rightHight = height[rightIndex];

			area = (rightIndex - leftIndex) * (leftHight < rightHight ? leftHight : rightHight);
			maxArea = maxArea < area ? area : maxArea;

			if (leftHight < rightHight) {
				do {
					leftIndex++;
				} while (leftIndex < rightIndex && height[leftIndex - 1] >= height[leftIndex]);
			} else {
				do {
					rightIndex--;
				} while (rightIndex > leftIndex && height[rightIndex + 1] >= height[rightIndex]);
			}
		}

		return maxArea;
	}
}
