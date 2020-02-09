package com.bamzhy.My_LeetCode.Code.p101_p200;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 */
public class LC120 {
    int minVal = Integer.MAX_VALUE;
    int length;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        length = triangle.size();
        doTraverse(triangle, 0, 0, 0);
        return minVal;
    }

    private void doTraverse(List<List<Integer>> triangle, int index, int val, int indexInEachLine) {
        if (index == length) {
            minVal = Math.min(minVal, val);
            return;
        }

        List<Integer> eachLine = triangle.get(index);
        for (int i = indexInEachLine; i < indexInEachLine + 2 && i < eachLine.size(); i++) {
            val += eachLine.get(i);
            doTraverse(triangle, index + 1, val, i);
            val -= eachLine.get(i);
        }
    }
}
