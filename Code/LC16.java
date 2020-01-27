package com.bamzhy.My_LeetCode.Code;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        // O(nlogn)
        Arrays.sort(nums);
        // store the closest number
        int ans = nums[0] + nums[1] + nums[2];
        // start == i +1 , end == nums.length - 1
        // O(n^2)
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    // Enumeration method
    public int threeSumClosestEnumeration(int[] nums, int target) {
        HashMap<Integer, String> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (i != j && j != k) {
                        res.put(Math.abs(nums[i] + nums[j] + nums[k] - target),
                                nums[i] + "," + nums[j] + "," + nums[k]);
                    }
                }
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int key : res.keySet()) {
            temp.add(key);
        }
        Collections.sort(temp);
        System.out.println(temp.get(0));

        System.out.println(res.get(temp.get(0)));
        String resString = res.get(temp.get(0));

        String[] split = resString.split(",");

        return Integer.valueOf(split[0]) + Integer.valueOf(split[1]) + Integer.valueOf(split[2]);
    }

    public int threeSumClosestRepeat(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] arrs = {1,1,1,1,0};
        System.out.println(new LC16().threeSumClosestRepeat(arrs, 100));
    }
}
