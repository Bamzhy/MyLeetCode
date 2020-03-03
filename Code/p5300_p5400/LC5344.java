package com.bamzhy.My_LeetCode.Code.p5300_p5400;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 5344. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * <p>
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 */

/** Accepted */
public class LC5344 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        HashMap<Integer, Integer> tempMap = new HashMap<>();
        int[] tempArray = new int[nums.length];
        int[] res = new int[nums.length];

        System.arraycopy(nums, 0, tempArray, 0, nums.length);
        Arrays.sort(tempArray);

        tempMap.put(tempArray[0], 0);
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] != tempArray[i - 1]) {
                tempMap.put(tempArray[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = tempMap.get(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {8, 1, 2, 2, 3};
        int[] b = {7, 7, 7, 7};
        System.out.println(Arrays.toString(new LC5344().smallerNumbersThanCurrent(null)));
    }
}
