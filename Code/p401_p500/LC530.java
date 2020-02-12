package com.bamzhy.My_LeetCode.Code.p401_p500;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 */
public class LC530 {
    Integer pre, res;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null)
            res = Math.min(res, Math.abs(pre - root.val));
        pre = root.val;
        dfs(root.right);
    }
}
