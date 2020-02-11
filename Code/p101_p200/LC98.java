package com.bamzhy.My_LeetCode.Code.p101_p200;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class LC98 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return doRob(nums, 0);
    }

    private int doRob(int[] nums, int index) {
        if (index >= nums.length) return 0;

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.min(res, nums[i] + doRob(nums, i + 2));
        }

        return res;
    }

    int[] memo;

    public int robMS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        memo = new int[nums.length + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        doRobMS(nums, 0);
        return memo[0];
    }

    private int doRobMS(int[] nums, int index) {
        if (index >= nums.length) return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.min(res, nums[i] + doRobMS(nums, i + 2));
        }
        memo[index] = res;

        return res;
    }

    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }
        memo[n] = nums[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[1];
    }
}
