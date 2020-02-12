package com.bamzhy.My_LeetCode.Code.p601_p700;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;

/**
 * Given a Binary Search Tree (BST) with the root node root,
 * return the minimum difference between the values of any two different nodes in the tree.
 */
public class LC783 {
    ArrayList<Integer> list;

    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    Integer pre, res;

    public int minDiffInBSTLeetCode(TreeNode root) {
        list = new ArrayList<>();
        pre = null;
        res = Integer.MAX_VALUE;
        dfs(root);

        return res;
    }

    private void dfsLeetCode(TreeNode root) {
        if (root == null)
            return;
        dfsLeetCode(root.left);
        if (pre != null)
            res = Math.min(res, root.val - pre);
        pre = root.val;
        dfsLeetCode(root.right);
    }
}
