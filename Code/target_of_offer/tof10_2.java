package com.bamzhy.My_LeetCode.Code.target_of_offer;

/**
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-10
 */
public class tof10_2 {
    private int[] list;

    public int numWays(int n) {
        if (n <= 1) return 1;
        list = new int[n + 1];
        list[1] = 1;
        list[2] = 2;
        doJump(n);
        return list[n];
    }

    private int doJump(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        if (list[n] == 0) {
            list[n] = (doJump(n - 1) + doJump(n - 2)) % 1000000007;
        }
        return list[n];
    }
}
