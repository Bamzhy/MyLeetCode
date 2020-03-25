package com.bamzhy.My_LeetCode.Code.target_of_offer;

/**
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-10
 */
public class tof10_1 {
    public int fib1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    private int[] array;

    public int fib2(int n) {
        if (n <= 0)
            return 0;
        array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        doFib(n);
        return array[n];
    }

    private int doFib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (array[n] == 0) {
            array[n] = (doFib(n - 1) + doFib(n - 2)) % 1000000007;
        }
        return array[n];
    }

    public static void main(String[] args) {
        tof10_1 tof10_1 = new tof10_1();
        System.out.println(tof10_1.fib2(48));
    }
}
