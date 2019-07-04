package com.homework.sort;

import java.util.Arrays;

/**
 * 冒泡排序(Bubble Sort)，又被称为气泡排序或泡沫排序。
 * 
 * 
 * @Author: lei.zhang
 * @Email: lei.zhang@rograndec.com
 * @CreateDate: 2019/7/4
 * @Version: 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[] {9,8,7,6,5,3,2,1})));
    }
    
    private static int[] bubbleSort(int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = 0; j < source.length - 1 - i; j++) {
                if (source[j] > source[j+1]) {
                    int temp = source[j + 1];
                    source[j+1] = source[j];
                    source[j] = temp;
                }
            }
        }
        
        return source;
    }
}
