package com.bamzhy.My_LeetCode.Code;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers,find if the array contains any duplicates
 * Your function should return true if any value appears at least twice in the array
 * and it should return false if every element is distinct
 */
public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
        }
        return false;
    }
    public boolean containsDuplicateLeetCode(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

}
