package com.bamzhy.My_LeetCode.Code.p101_p200;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class LC103 {
    public List<List<Integer>> zigzagLevelOrderLeetCode(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.removeFirst();
                if (depth % 2 == 0) tmp.add(node.val);
                else tmp.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
            depth++;
        }
        return res;
    }

    class LevelOrderNode {
        int level;
        TreeNode node;

        LevelOrderNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        HashMap<Integer, Stack<Integer>> oddMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> evenMap = new HashMap<>();
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

            int size = oddMap.size() + evenMap.size();
            if (level % 2 == 0) {
                if (level == size)
                    evenMap.put(level, new ArrayList<>());
                evenMap.get(level).add(key.val);
            } else {
                if (level == size)
                    oddMap.put(level, new Stack<>());
                oddMap.get(level).push(key.val);
            }

            if (key.left != null) {
                queue.add(new LevelOrderNode(key.left, level + 1));
            }
            if (key.right != null) {
                queue.add(new LevelOrderNode(key.right, level + 1));
            }
        }

        int level = oddMap.size() + evenMap.size();
        for (int a : oddMap.keySet()) {
            System.out.println(a + " " + oddMap.get(a));
        }
        for (int a : evenMap.keySet()) {
            System.out.println(a + " " + evenMap.get(a));
        }

        for (int i = 0; i < level; i++) {
            if (i % 2 == 0) {
                res.add(evenMap.get(i));
            } else {
                Stack<Integer> stack = oddMap.get(i);
                ArrayList<Integer> array = new ArrayList<>();
                if (stack != null) {
                    while (!stack.isEmpty()) {
                        array.add(stack.pop());
                    }
                }
                res.add(array);
            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrderRepeat(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }
        queue.add(root);
        int depth = 0;

        while (queue.size() > 0) {
            ArrayList<Integer> temp = new ArrayList<>();

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.removeFirst();
                if (depth % 2 == 0) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(temp);
            depth++;
        }
        return res;
    }
}
