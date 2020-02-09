package com.bamzhy.My_LeetCode.Code.p101_p200;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class LC110 {
    public boolean isBalancedLeetCode1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalancedLeetCode1(root.left) && isBalancedLeetCode1(root.right);

    }

    private int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalancedLeetCode2(TreeNode root) {
        return getTreeDepth2(root) != -1;
    }

    private int getTreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth2(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getTreeDepth2(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static ArrayList<Integer> list;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        list = new ArrayList<>();
        getAllDepth(root);
        System.out.println(Arrays.toString(list.toArray()));
        if (list.size() > 0) {
            Collections.sort(list);
            return list.get(list.size() - 1) - list.get(0) <= 1;
        }
        return true;
    }

    private int getAllDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
            return root.val;
        }
        int temp = 0;
        if (root.left != null) {
            return getAllDepth(root.left) + root.val;
        }
        list.add(temp);
        temp = 0;
        if (root.right != null) {
            return getAllDepth(root.right) + root.val;
        }
        list.add(temp);
        return 0;
    }
}
