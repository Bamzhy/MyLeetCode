package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class LC111 {
    /* I cannot pass the test case [1,2] because this answer didn't cover situation 2

       1 When the root node didn't have any child nodes,return 1
       2 the root only have one child node, return the childNode 's depth +1
       3 the root have two child nodes, return the min value of the two trees' depth +1

     */
    public int minDepthFinal(TreeNode root) {
        if (root == null) return 0;

        // 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepthFinal(root.left);
        int right = minDepthFinal(root.right);

        // 2
        // 当前节点左右子树有一个为空时，返回的应是非空子树的最小深度，而不是空子树深度0
        // 若返回0相当于把当前节点认为成叶子节点，与此节点有非空子树矛盾。
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        //3
        return Math.min(left, right) + 1;
    }

    public int minDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int res = Integer.MAX_VALUE;
        if (root.left != null) {
            res = Math.min(res, minDepthRecursive(root.left) + 1);
        }
        if (root.right != null) {
            res = Math.min(res, minDepthRecursive(root.right) + 1);
        }
        return res;
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
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);

        root.left = node;

        System.out.println(new LC111().minDepthFinal(root));
    }
}
