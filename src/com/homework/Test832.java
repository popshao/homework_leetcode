package com.homework;
/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */

import com.alibaba.fastjson.JSON;

/**
 *                       
 * @Filename: Test467.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test832 {

    // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] 预期结果
    // [[1,1,0,0],[1,1,1,1],[0,1,1,1],[1,0,1,0]] 执行结果
    public static void main(String[] args) {
        Test832 test = new Test832();
        int[][] arr = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println(JSON.toJSONString(test.flipAndInvertImage(arr)));
    }
    
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i].length % 2 == 0) { // 偶数
                    if (j == A[i].length / 2) {
                        break;
                    } else {
                        int temp = A[i][j];
                        A[i][j] = A[i][A[i].length - j - 1] ^ 1;
                        A[i][A[i].length - j - 1] = temp ^ 1;
                    }
                    
                } else { // 奇数
                    if (j == (A[i].length + 1) / 2) {
                        break;
                    } else {
                        int temp = A[i][j];
                        A[i][j] = A[i][A[i].length - j - 1] ^ 1;
                        A[i][A[i].length - j - 1] = temp ^ 1;
                    }
                }
            }
        }
        
        return A;
    }
    

}
