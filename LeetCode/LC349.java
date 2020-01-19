package com.bamzhy.My_LeetCode.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC349 {
    /**
     * 在jdk1.8版本后，java对HashMap做了改进，
     * 在Hash表中的任意链表长度大于8的时候，将后面的数据存在红黑树中，以加快检索速度。
     * 这样结合了红黑树和Hash表，效率很好
     * HashMap无序
     * LinkedHashMap有序
     * TreeMap按key排序
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        int i = 0;
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int a : nums1) {
            tempMap.put(a, null);
        }
        for (int b : nums2) {
            if (tempMap.containsKey(b) && tempMap.get(b) == null) {
                tempMap.put(b, 1);
                i++;
            }
        }
        int[] result = new int[i];
        for (int c : tempMap.keySet()) {
            if (tempMap.get(c) != null && (i - 1) >= 0) {
                result[i - 1] = c;
                i--;
            }
        }
        return result;
    }

    public int[] intersectionbamzhy(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int a : nums1) {
            tempMap.put(a, null);
        }
        for (int b : nums2) {
            if (tempMap.containsKey(b)) {
                tempMap.put(b, 1);
            }
        }
        for (int c : tempMap.keySet()) {
            if (tempMap.get(c) != null) {
                sb.append(c).append(",");
            }
        }
        System.out.println(sb.toString());
        int length = sb.length();
        if (length > 0) {
            String[] s = sb.substring(0, length - 1).split(",");
            int[] result = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                result[i] = Integer.valueOf(s[i]);
            }
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1, 3}, nums2 = {2, 2, 3, 4};
        int[] result = new LC349().intersectionSecond(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public int[] intersectionBest(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2 || 0 == nums1.length || 0 == nums2.length) {
            return new int[0];
        }
        // 利用好二分查找logN级别
        Arrays.sort(nums1); // 对数组1排序
        Arrays.sort(nums2); // 对数组2排序
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[] outerArray = null;
        int[] innerArray = null;
        if (nums1Len < nums2Len) {
            outerArray = nums1;
            innerArray = nums2;
        } else {
            outerArray = nums2;
            innerArray = nums1;
        }

        int[] preResult = new int[outerArray.length];
        int preResultIndex = 0;
        int usedNum = outerArray[0];
        if (Arrays.binarySearch(innerArray, usedNum) >= 0) {
            preResult[preResultIndex++] = usedNum;
        }
        // 在preResult中存放重复值，并且记录长度
        for (int index = 1; index < outerArray.length; index++) {
            // 手动去重
            if (outerArray[index] == usedNum) {
                continue;
            }
            usedNum = outerArray[index];
            if (Arrays.binarySearch(innerArray, usedNum) >= 0) {
                preResult[preResultIndex++] = usedNum;
            }
        }
        // 截取preResult中的符合要求数据，并且放进result中返回
        int[] result = new int[preResultIndex];
        System.arraycopy(preResult, 0, result, 0, preResultIndex);

        return result;
    }

    public int[] intersectionSecond(int[] nums1, int[] nums2) {
        // 给俩数组去重
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            set2.add(n);
        }
        if (set1.size() < set2.size()) {
            return setIntersection(set1, set2);
        } else {
            return setIntersection(set2, set1);
        }
    }

    // 获取俩set中的共同值
    private int[] setIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            if (set2.contains(s)) {
                output[idx++] = s;
            }
        }
        // 为什么不直接返回output是因为idx到set1.size()之间是0
        return Arrays.copyOf(output, idx);
    }
}
