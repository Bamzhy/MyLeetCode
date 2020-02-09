package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class LC70 {
    int[] temp;

    public int climbStairs(int n) {
        temp = new int[n + 1];
        Arrays.fill(temp, -1);
        return calWays(n);
    }

    private int calWays(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (temp[n] == -1)
            temp[n] = calWays(n - 1) + calWays(n - 2);
        return temp[n];
    }

    public int climbStairsDp(int n) {
        if (n <= 0) return 0;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
