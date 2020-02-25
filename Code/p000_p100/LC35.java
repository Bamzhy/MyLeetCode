package com.bamzhy.My_LeetCode.Code.p000_p100;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        // 确定是否在
        if (target <= nums[0]) return 0;

        if (target == nums[nums.length - 1])
            return nums.length - 1;
        else if (target > nums[nums.length - 1])
            return nums.length;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == target)
                return i;
            if (nums[i - 1] <= target && nums[i] >= target)
                return i;
        }
        return 0;
    }

//    public int searchInsertBinary(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return 0;
//
//
//    }
}
