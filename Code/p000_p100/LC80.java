package com.bamzhy.My_LeetCode.Code.p000_p100;

public class LC80 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     */

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0, j = 0;// i标记符合要求的数组index; j标记下一个不同值所在位置
        while (j < nums.length) {
            int k = getNextIndex(nums, j); //往下找下一个不同值，并且返回index,
            int len = Math.min(2, k - j); //往下走len才能找到不同值
            for (int l = 0; l < len; l++) {
                nums[i + l] = nums[j]; //核心逻辑，用nums[j]覆盖掉len长度的值
            }
            i += len;
            j = k;
        }
        return i;
    }

    public int getNextIndex(int[] nums, int j) {
        for (int i = j; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                return i;
            }
        }
        return nums.length;
    }

}
