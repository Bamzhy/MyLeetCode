package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    public static void main(String[] args) {
        int[] a = {4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5};
        int target = -13;
        System.out.println(new LC18().fourSum(a, target));
    }

    /**
     * 1 暴力获取 O(n^4)
     * 2 沿用three sum的思路
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<List<Integer>> tempListForTwoSum;
        Arrays.sort(nums);

        if (nums.length < 4) return resultList;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target && target > 0) return resultList;
            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            // 从index开始获取所有元素中 三个数之和等于target的数组
            tempListForTwoSum = getThreeNumbers(nums, i + 1, target - nums[i]);
            if (tempListForTwoSum.size() > 0) {
                for (List<Integer> a : tempListForTwoSum) {
                    resultList.add(Arrays.asList(nums[i], a.get(0), a.get(1), a.get(2)));
                }
            }
        }
        return resultList;

    }

    private List<List<Integer>> getThreeNumbers(int[] nums, int index, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target && target > 0) return resultList;
            // if (i + 1 < nums.length && nums[i] == nums[i + 1]) i++就去重了，;
            if (i > index && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int value = nums[i] + nums[L] + nums[R];
                if (value == target) {
                    while (L + 1 < nums.length && nums[L] == nums[L + 1]) L++;
                    while (R - 1 > index && nums[R] == nums[R - 1]) R--;
                    resultList.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    L++;
                    R--;
                } else if (value < target) {
                    L++;
                } else if (value > target) {
                    R--;
                }
            }

        }
        return resultList;
    }
}
