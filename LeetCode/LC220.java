package com.bamzhy.My_LeetCode.LeetCode;

import java.util.TreeSet;

public class LC220 {
    // TreeSet is an ordered set
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647};
        int k = 3;
        int t = 3;
        System.out.println(new LC220().containsNearbyAlmostDuplicate(nums, k,t));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long temp = record.ceiling((long)nums[i] - (long)t);
            if (temp != null && temp <= ((long)nums[i] + t)) {
                return true;
            }
            record.add((long)nums[i]);
            if (record.size() == k + 1) {
                record.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
