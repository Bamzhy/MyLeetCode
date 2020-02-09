package com.bamzhy.My_LeetCode.Code.p201_p300;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
public class LC219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(new LC219().containsNearbyDuplicate(nums, k));
    }

    // time complexity is too high
    public boolean containsNearbyDuplicateBamzhy(int[] nums, int k) {
        if (nums == null) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;//左右指针
        while (j < nums.length) {
            if (j - i <= k) {
                if (checkExist(nums, i, j, map))
                    return true;
                else
                    j++;
            } else {
                i++;
            }
        }
        return false;
    }

    private boolean checkExist(int[] nums, int i, int j, HashMap<Integer, Integer> map) {
        map.clear();
        for (int k = i; k < j + 1; k++) {
            map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
            if (map.get(nums[k]) > 1) {
                return true;
            }
        }
        return false;
    }
}
