package com.bamzhy.My_LeetCode.Code.p301_p400;

/**
 * Given a positive integer n,
 * break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 */
public class LC343 {

    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1)
            return 1;

        if (memo[n] != -1)
            return memo[n];

        // concern! res cannot be a global variable, because we just need to record one cycle's max value
        // not one cycle's max value * another cycle's
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = maxThree(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int maxThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int integerBreakDp(int n) {
        memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = maxThree(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new LC343().breakInteger(3));
    }
}
