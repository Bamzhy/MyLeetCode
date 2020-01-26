package com.bamzhy.My_LeetCode.Code;

import java.util.HashMap;

public class LC447 {
    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(new LC447().numberOfBoomerangs(a));
    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (map.containsKey(d)) {
                    res += map.get(d) * 2;
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
            }
        }
        return res;
    }

    public int numberOfBoomerangsBamzhy(int[][] points) {
        if (points == null || points.length < 3) return 0;
        int result = 0;
        HashMap<Integer, Integer> recordMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            recordMap.clear();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                            + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    if (recordMap.containsKey(distance)){
                        recordMap.put(distance, recordMap.getOrDefault(distance, 0) + 1);
                    }else{
                        recordMap.put(distance, 1);
                    }

                }

            }
//            for (int a : recordMap.keySet()) {
//                int times = recordMap.get(a);
//                if (times >= 2) {
//                    result += times * (times - 1);
//                }
//            }
        }
        return result;
    }
}
