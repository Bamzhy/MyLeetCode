package com.bamzhy.My_LeetCode.Code.p000_p100;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        if (q == null && p != null) return false;

        if (p != null && q != null) {
            if (p.val != q.val) return false;
            if(!isSameTree(p.left, q.left)) return false;
            if(!isSameTree(p.right, q.right)) return false;
        }
        return true;
    }

    // simplified version
    public boolean isSameTreeLeetCode(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTreeLeetCode(p.right, q.right) &&
                isSameTreeLeetCode(p.left, q.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root2.right = new TreeNode(2);

        System.out.println(new LC100().isSameTree(root1, root2));
    }
}
