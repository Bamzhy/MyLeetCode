package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 */
public class LC102 {
    class LevelOrderNode {
        TreeNode node;
        int level;

        LevelOrderNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // use a linked list as a first in first out queue
        LinkedList<LevelOrderNode> queue = new LinkedList<>();
        queue.addLast(new LevelOrderNode(root, 0));

        while (queue.size() > 0) {
            LevelOrderNode node = queue.removeFirst();
            TreeNode key = node.node;
            int level = node.level;

            if (level == res.size())
                res.add(new ArrayList<>());

            res.get(level).add(key.val);

            if (key.left != null) {
                queue.add(new LevelOrderNode(key.left, level + 1));
            }
            if (key.right != null) {
                queue.add(new LevelOrderNode(key.right, level + 1));
            }
        }
        return res;
    }
}
