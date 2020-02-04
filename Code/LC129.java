package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */
public class LC129 {
    public int sumNumbers(TreeNode root) {
        int value = 0;
        if (root == null) return 0;
        ArrayList<String> list = dfs(root);
        System.out.println(Arrays.toString(list.toArray()));
        for (String a : list) {
            if (a!=null&&!a.equals("")){
                value+=Integer.valueOf(a);
            }
        }
        return value;
    }

    private ArrayList<String> dfs(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) return list;

        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }

        ArrayList<String> left = dfs(root.left);
        for (String a : left) {
            list.add(root.val + "" + a);
        }

        ArrayList<String> right = dfs(root.right);
        for (String a : right) {
            list.add(root.val + "" + a);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(new LC129().sumNumbers(node1));
    }
}
