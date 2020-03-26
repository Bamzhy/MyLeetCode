package com.bamzhy.My_LeetCode.Code.target_of_offer;

/**
 * @author bamzhy
 * @version 1.0.0
 * @date 2020/3/26
 */
public class tof11 {
    // not good enough
    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        if (numbers == null || numbers.length == 0)
            throw new IllegalArgumentException("input shouldn't be empty");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= min)
                min = numbers[i];
        }
        return min;
    }

}
