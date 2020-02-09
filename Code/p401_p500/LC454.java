package com.bamzhy.My_LeetCode.Code.p401_p500;

import java.util.HashMap;


/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
 * 使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
 * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */

public class LC454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 使用一个Map来存放所有C和D的和，所以时间复杂度是O(n^2),空间复杂度是O(n^2)
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int cValue : C) {
            for (int dValue : D) {
                int key = cValue + dValue;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        for (int aValue : A) {
            for (int bValue : B) {
                int key = aValue + bValue;
                if (map.containsKey(0 - key)) {
                    result += map.get(0 - key);
                }
            }
        }
        return result;
    }
}
