package com.bamzhy.My_LeetCode.Code.p301_p400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LC350 {
    public int[] intersectBamzhy1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int a : nums1) {
            if (tempMap.get(a) == null) {
                tempMap.put(a, 1);
            } else {
                int result = tempMap.get(a);
                tempMap.put(a, ++result);
            }
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int a : nums2) {
            if (null != tempMap.get(a) && tempMap.get(a) != 0) {
                Integer value = tempMap.get(a);
                tempMap.put(a, --value);
                resultList.add(a);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public int[] intersectBamzhy2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int a : nums1) {
            tempMap.put(a, tempMap.getOrDefault(a, 0) + 1);
        }
        int i = 0;
        for (int a : nums2) {
            Integer value = tempMap.getOrDefault(a, 0);
            if (value != 0) {
                tempMap.put(a, value - 1);
                nums1[i] = a;
                i++;
            }
        }

        return Arrays.copyOf(nums1, i);
    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(0));
    }
}
