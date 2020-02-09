package com.bamzhy.My_LeetCode.Code.p401_p500;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 */
public class LC404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        int res = 0;
        if (node.left == null && node.right == null && isLeft)
            return node.val;

        if (node.left != null) {
            res += dfs(node.left, true);
        }
        if (node.right != null) {
            res += dfs(node.right, false);
        }
        return res;
    }

    static int res = 0;

    public int sumOfLeftLeavesBobo2(TreeNode root) {
        if (root == null) return 0;
        dfsBobo2(root, false);
        return res;
    }

    private void dfsBobo2(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft)
            res += node.val;

        if (node.left != null) {
            dfsBobo2(node.left, true);
        }
        if (node.right != null) {
            dfsBobo2(node.right, false);
        }
    }

    public int sumOfLeftNodes(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null)
            res += (sumOfLeftLeaves(root.left) + root.left.val);
        if (root.right != null)
            res += sumOfLeftLeaves(root.right);
        return res;
    }

    // {3,9,20,null,null,15,7}
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

//        root.left = node1;
//        root.right = node2;
//
//        node2.left = node3;
//        node2.right = node4;
        System.out.println(new LC404().sumOfLeftLeavesBobo2(root));
    }
}
