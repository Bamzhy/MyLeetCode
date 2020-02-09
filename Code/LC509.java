package com.bamzhy.My_LeetCode.Code;

import java.util.Arrays;

public class LC509 {
    static int[] memo;

    public int fibOrigin(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public int fib(int n) {
        if (n <= 0) return 0;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dpFib(n);
    }

    private int dpFib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (memo[n] == -1)
            memo[n] = dpFib(n - 1) + dpFib(n - 2);
        return memo[n];
    }

    public int fidDp(int n) {
        if (n <= 0) return 0;
        memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        System.out.println(new LC509().fib(40));
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(new LC509().fibOrigin(40));
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));
    }
}
