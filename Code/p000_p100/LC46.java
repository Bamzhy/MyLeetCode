package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class LC46 {
    static List<List<Integer>> res;
    // store all numbers' state in one cycle
    static List<Boolean> used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        used = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            used.add(false);
        }

        if (nums.length == 0) return res;
        ArrayList<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    private void generatePermutation(int[] nums, int index, ArrayList<Integer> p) {
        if (index == nums.length) {
            System.out.println("return____" + p.toString());
            ArrayList<Integer> q = new ArrayList<>(p.size());
            q.addAll(p);
            res.add(q);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.get(i)) {
                p.add(nums[i]);
                used.set(i, true);
                generatePermutation(nums, index + 1, p);
                p.remove(Integer.valueOf(nums[i]));
                used.set(i, false);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(new LC46().permute(a));
    }
}
