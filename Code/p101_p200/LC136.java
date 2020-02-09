package com.bamzhy.My_LeetCode.Code.p101_p200;

import java.util.HashSet;

/**
 * Given a non-empty array of integers,
 * every element appears twice except for one. Find that single one.
 */

public class LC136 {
    // exclusive OR can make sure the same number can be turned into zero
    public int singleNumberBest(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a = a ^ i;
        }
        return a;
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                record.remove(nums[i]);
            } else {
                record.add(nums[i]);
            }
        }
        for (int a : record) return a;
        return 0;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = 1;
        System.out.println(a^b^c^b^c);
        System.out.println(a^b^c^a^c);
        System.out.println(a^b^c^a^b);
    }
}
