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
        if (n <= 0 || k <= 0 || k > n) return res;

        ArrayList<Integer> p = new ArrayList<>();
        generateCombinations(n, k, 1, p);

        return res;
    }

    private void generateCombinations(int n, int k, int start, ArrayList<Integer> p) {
        if (p.size() == k) {
            res.add(new ArrayList<>(p));
            return;
        }

        // i <= n ---> i <= n - (k-p.size()) + 1
        for (int i = start; i <= n - (k - p.size()) + 1; i++) {
            p.add(i);
            generateCombinations(n, k, i + 1, p);
            p.remove(Integer.valueOf(i));
        }
    }
}
