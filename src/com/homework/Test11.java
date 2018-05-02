package com.homework;

public class Test11 {

	public static void main(String[] args) {
		
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
