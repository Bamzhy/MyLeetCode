package com.bamzhy.My_LeetCode.Code.p101_p200;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0)
            res.add(new ArrayList<>(tmp));
        helper(root.left, sum - root.val, res, tmp);
        helper(root.right, sum - root.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }

    public List<List<Integer>> pathSumFirst(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<String> tempList = dfs(root);
        System.out.println(Arrays.toString(tempList.toArray()));
        for (String a : tempList) {
            if (a != null && a.length() > 1) {
                String[] split = a.split(",");
                List<Integer> list = new ArrayList<>();
                int value = 0;
                for (String b : split) {
                    if (b != null && !b.equals("")) {
                        value += Integer.valueOf(b);
                        list.add(Integer.valueOf(b));
                    }
                }
                if (value == sum) {}
            }
        }
        return res;

    }

    private List<String> dfs(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
        }
        List<String> leftList = dfs(root.left);
        for (String a : leftList) {
            res.add(root.val + "," + a);
        }

        List<String> rightList = dfs(root.right);
        for (String a : rightList) {
            res.add(root.val + "," + a);
        }
        return res;
    }

    public List<List<Integer>> pathSumBetter(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> tempList = dfsBetter(root);
        System.out.println(Arrays.toString(tempList.toArray()));
        for (List<Integer> a : tempList) {
            if (a != null && a.size() > 0) {
                int value = 0;
                for (int b : a) {
                    value += b;
                }
                if (value == sum) res.add(a);
            }
        }
        return res;
    }

    private List<List<Integer>> dfsBetter(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            res.add(temp);
        }
        List<List<Integer>> leftList = dfsBetter(root.left);
        for (List<Integer> a : leftList) {
            a.add(0,root.val);
            res.add(a);
        }

        List<List<Integer>> rightList = dfsBetter(root.right);
        for (List<Integer> a : rightList) {
            a.add(0,root.val);
            res.add(a);
        }
        return res;
    }
}
