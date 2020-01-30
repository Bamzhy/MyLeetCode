package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class LC111 {
    // maybe we can't use Recursive method
    public int minDepthRecursive(TreeNode root) {
        return 0;
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Command> queue = new LinkedList<>();
        int minDepth = Integer.MAX_VALUE;
        queue.add(new Command(root, 1));
        while (queue.size() > 0) {
            Command command = queue.poll();
            if (command.node != null) {
                if (command.node.left != null) {
                    queue.add(new Command(command.node.left, command.level + 1));
                }
                if (command.node.right != null) {
                    queue.add(new Command(command.node.right, command.level + 1));
                }
                if (command.node.left == null && command.node.right == null) {
                    minDepth = Math.min(command.level, minDepth);
                }
            }
        }
        return minDepth;
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
        TreeNode root = new TreeNode(0);

        System.out.println(new LC111().minDepth(root));
    }
}
