package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums[]和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
 *
 * 1 暴力法 O(n^2)
 * 2 把nums[]排序以后用双指针法(滑动窗口不行因为可以不连续，但是排序后二分法查找target-a是可以的),
 *        但是难点在于排序后如何记录之前nums的index(其实不用记录，扫一遍就好了)
 * 3 把所有的nums[]存入一个Map中，key是值，value是序号，value会被覆盖，但是本题只要求返回一对值所以无伤大雅
 */
public class LC1 {
    // 最好的解法 只扫一遍map 原理是map做了一遍去重只保留有效值，而最终的两个值一定会保存进key中
    // a + b = target
    // 原理：第一次出现a时你无法从map的key中找到b，
    // 但是你找到b时一定可以从map的key中找到a，返回a,b即可
    public int[] twoSum2PlusPlus(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //
    public int[] twoSum2Plus(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 这里特别巧，map.get(complement)==i代表只有他自己
            // map.get(complement)!=i代表还有另外一个值覆盖了之前key为complement value为i的键值对
            // 这样的做法在三数、四数之和中就不能用了，因为覆盖掉的值>2了
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums.length == 0)
            return new int[0];
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int l = 0;
        int[] result = new int[2];
        while (l + 1 < nums.length) {
            int a = temp[l];
            int b = target - a;
            int bResult = Arrays.binarySearch(temp, l + 1, nums.length, b);
            if (bResult > 0) {
                if (a != b) {
                    for (int i = 0; i < nums.length; i++) {
                        if (a == nums[i]) {
                            result[0] = i;
                        }
                        if (b == nums[i]) {
                            result[1] = i;
                        }
                    }
                } else {
                    int j = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if (a == nums[i] && j < 2) {
                            result[j] = i;
                            j++;
                        }
                    }
                }
                return result;
            }
            l++;
        }
        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {
        if (nums.length == 0)
            return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int a : map.keySet()) {
            int b = target - a;
            if (map.containsKey(b)) {
                if (map.get(a).equals(map.get(b))) {
                    //此时出现了数组里有一对重复数并且相加的和==target的情况，我们需要去数组里头遍历获取index
                    int j = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if (a == nums[i] && j < 2) {
                            result[j] = i;
                            j++;
                        }
                    }
                } else {
                    result[0] = map.get(a);
                    result[1] = map.get(b);
                }
                return result;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 8, 5, 20};
        int b = 3;
        System.out.println(Arrays.toString(new LC1().twoSum2PlusPlus(a, b)));
    }
}
