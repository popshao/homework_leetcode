/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，
 * 该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * 
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 
 */
public class Test304 {

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    public static void main(String[] args) {
        int[][] attr = {{3,0,1,4,2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(attr);
        System.out.print(obj.sumRegion(2, 1, 4, 3));
    }
    
}

class NumMatrix {
    private int[][] dp;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r][c + 1] = dp[r][c] + matrix[r][c];
            }
        }
        
        System.out.println(JSON.toJSONString(dp));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += dp[row][col2 + 1] - dp[row][col1];
        }
        return sum;
    }

}

class NumMatrix2 {
    int[][] matrix;
    public NumMatrix2(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum = sum + matrix[i][j];
            }
        }
        
        return sum;
    } 
}
