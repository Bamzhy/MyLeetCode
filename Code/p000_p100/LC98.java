package com.bamzhy.My_LeetCode.Code.p000_p100;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *  
 */
public class LC98 {
    public static ArrayList<Integer> list;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        list = new ArrayList<>();
        dfs(root);
        if (list.size() > 0) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) >= list.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
