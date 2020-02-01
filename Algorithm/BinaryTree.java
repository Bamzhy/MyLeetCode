package com.bamzhy.My_LeetCode.Algorithm;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

public class BinaryTree {
    void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    boolean contains(TreeNode node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.val) {
            return true;
        }
        if (contains(node.left, key) || contains(node.right, key)) {
            return true;
        }
        return false;
    }

    // java has a GC ,so we needn't do delete
    void destory(TreeNode node) {
    }

    // get a tree' s depth
    int getDepth(TreeNode node) {
        if (node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        // get the max value of each node's left right tree
        // value + 1 represents the current node's height
        return Math.max(left, right) + 1;
    }
}
