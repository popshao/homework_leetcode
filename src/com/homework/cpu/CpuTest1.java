/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework.cpu;

import java.util.Date;

/**
 *                       
 * @Filename: CpuTest1.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class CpuTest1 {
    
    public static void main(String[] args) {
        int row = 1024;
        int column = 512;
        
        int[][] matrix = new int[row][column];
        
        Date timeStart = new Date();
        int rowSum = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                rowSum += matrix[r][c];
            }
        }
        Date timeEnd = new Date();
        System.out.println("¼ÆËã1" + (timeEnd.getTime() - timeStart.getTime()));
        
        timeStart = new Date();
        int colSum = 0;
        for(int c = 0; c < column; c++) {
            for (int r = 0; r < row; r++) {
                colSum += matrix[r][c];
            }
        }
        timeEnd = new Date();
        System.out.println("¼ÆËã1" + (timeEnd.getTime() - timeStart.getTime()));
    }
}
