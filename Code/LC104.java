package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.LinkedList;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class LC104 {
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepthRecursive(root.left);
        int rightMaxDepth = maxDepthRecursive(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    // use queue do level traverse
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<Command> queue = new LinkedList<>();
        int maxDepth = 1;
        queue.add(new Command(root, 1));
        while (queue.size() > 0) {
            Command command = queue.poll();
            if (command.node != null && command.node.left != null) {
                queue.add(new Command(command.node.left, command.level + 1));
                maxDepth = Math.max(command.level + 1, maxDepth);
            }
            if (command.node != null && command.node.right != null) {
                queue.add(new Command(command.node.right, command.level + 1));
                maxDepth = Math.max(command.level + 1, maxDepth);
            }
        }
        return maxDepth;
    }

    class Command {
        int level;
        TreeNode node;

        Command(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node2.right = node4;

        System.out.println(new LC104().maxDepth(root));
    }
}
