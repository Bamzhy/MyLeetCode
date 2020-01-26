package com.bamzhy.My_LeetCode.Code;

import java.util.*;

public class LC347 {
    public List<Integer> topKFrequentBamzhy(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (map.get(a) < map.get(b)) {
                return 1;
            } else if (map.get(a) > map.get(b)) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int a : map.keySet()) {
            queue.add(a);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public List<Integer> topKFrequentLeetCode(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> [] bucket = new List[nums.length + 1];
        for (int key: map.keySet()){
            int freq = map.get(key);
            if (bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i]!=null&&result.size()<k)
                result.addAll(bucket[i]);
        }
        return result;
    }
}
