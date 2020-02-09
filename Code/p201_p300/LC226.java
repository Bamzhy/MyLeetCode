package com.bamzhy.My_LeetCode.Code.p201_p300;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

/**
 * invert a binary tree.
 */
public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
