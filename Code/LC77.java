package com.bamzhy.My_LeetCode.Code;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class LC77 {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        generateCombinations(n, k, 1, temp);
        return res;
    }

    void generateCombinations(int n, int k, int start, ArrayList<Integer> temp) {
        if (temp.size() == k) {
            ArrayList<Integer> p = new ArrayList<>(temp);
            res.add(p);
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            generateCombinations(n, k, i + 1, temp);
            temp.remove(Integer.valueOf(i));
        }
    }
}
