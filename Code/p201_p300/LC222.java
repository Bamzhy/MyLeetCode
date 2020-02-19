package com.bamzhy.My_LeetCode.Code.p201_p300;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.LinkedList;

/**
 * Given a complete binary tree, count the number of nodes.
 */
public class LC222 {
    LinkedList<TreeNode> queue;
    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        queue = new LinkedList<>();
        bfs(root);
        return count;
    }

    private void bfs(TreeNode root) {
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode node = queue.removeFirst();
            count++;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    public int countNodesLeetCode(TreeNode root) {
        if (root == null) return 0;
        System.out.println("this is node:" + root.val);
        int left = countNodesLeetCode(root.left);
        int right = countNodesLeetCode(root.right);
        return left + right + 1;
    }

    public int countNodesLeetCodeBest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodesLeetCodeBest(root.right) + (1 << left);
        } else {
            return countNodesLeetCodeBest(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
