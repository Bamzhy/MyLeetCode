package com.bamzhy.My_LeetCode.Code.target_of_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-10
 */
public class tof03 {
    // 用map去重
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Object> set = new HashMap<>();
        for (int num : nums) {
            if (set.containsKey(num))
                return num;
            else
                set.put(num, "");
        }
        return 0;
    }

    // 利用长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内 这个条件
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[nums[i]])
                return nums[i];
            else {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;
    }
}
