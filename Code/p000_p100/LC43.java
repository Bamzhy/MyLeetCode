package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.Arrays;

public class LC43 {
    public static void main(String[] args) {
        int[][] aim = new int[4][4];
        aim[0][0] = 5;
        aim[0][1] = 1;
        aim[0][2] = 9;
        aim[0][3] = 11;
        aim[1][0] = 2;
        aim[1][1] = 4;
        aim[1][2] = 8;
        aim[1][3] = 10;
        aim[2][0] = 13;
        aim[2][1] = 3;
        aim[2][2] = 6;
        aim[2][3] = 7;
        aim[3][0] = 15;
        aim[3][1] = 14;
        aim[3][2] = 12;
        aim[3][3] = 16;
        System.out.println(Arrays.deepToString(aim));
        new LC43().rotate(aim);
        System.out.println(Arrays.deepToString(aim));
    }

    /**
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     *
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     */

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rotateNum = (n + 1) / 2;
        for (int i = 0; i < rotateNum; i++) {
            // 每层遍历[i,n-i-1)是第一个要点，每一层最后一个点，n-i-1不旋转切记
            for (int j = i; j < n - i - 1; j++) {
                // 第二个要点旋转matrix[i][j]起始的四个点
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
