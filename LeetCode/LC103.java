package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class LC103 {
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

    private TreeNode createTreeNode(int[] arr, int index) {
        TreeNode node = null;
        while (index < arr.length) {
            node = new TreeNode(arr[index]);
            node.left = createTreeNode(arr, ++index);
            node.right = createTreeNode(arr, ++index);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};
        TreeNode tr = new LC103().createTreeNode(arr, 0);
        new LC103().zigzagLevelOrder(tr);
        System.out.println(tr);

    }
}
