package com.bamzhy.My_LeetCode.Code.target_of_offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 *
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-10
 */
public class tof04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows > 0) {
            int cols = matrix[0].length;
            if (matrix != null && rows > 0 && cols > 0) {
                int row = 0;
                int col = cols - 1;
                while (row < rows && col >= 0) {
                    if (matrix[row][col] == target)
                        return true;
                    else if (matrix[row][col] > target)
                        col--;
                    else
                        row++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
