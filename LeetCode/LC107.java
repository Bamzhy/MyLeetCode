package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
public class LC107 {
    class LevelOrderNode {
        int level;
        TreeNode node;

        LevelOrderNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> resTemp = new ArrayList<>();
        if (root == null) return res;

        LinkedList<LevelOrderNode> nodeList = new LinkedList<>();
        nodeList.add(new LevelOrderNode(root, 0));

        while (nodeList.size() != 0) {
            LevelOrderNode node = nodeList.removeFirst();
            TreeNode key = node.node;
            int level = node.level;

            if (level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(key.val);
            if (key.left != null) {
                nodeList.add(new LevelOrderNode(key.left, level + 1));
            }
            if (key.right != null) {
                nodeList.add(new LevelOrderNode(key.right, level + 1));
            }
        }

        stack.addAll(res);
        while (stack.size() != 0) {
            resTemp.add(stack.pop());
        }
        return resTemp;
    }
}
