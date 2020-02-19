package com.bamzhy.My_LeetCode.Code.p201_p300;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LC236 {
    private PriorityQueue<Node> list;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        list = new PriorityQueue<>((o1, o2) -> o1.level - o2.level);
        doLevelTraverse(root, p, q);
        return list.poll().treeNode;
    }

    private void doLevelTraverse(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, root));
        while (queue.size() > 0) {
            Node node = queue.removeFirst();
            boolean pb = findNode(root, p);
            boolean qb = findNode(root, q);
            if (pb && qb)
                list.add(node);
            if (node.treeNode.left != null)
                queue.add(new Node(node.level + 1, node.treeNode.left));
            if (node.treeNode.right != null)
                queue.add(new Node(node.level + 1, node.treeNode.right));
        }
    }

    private boolean findNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p)
            return true;
        findNode(root.left, p);
        //todo
        return false;
    }

    class Node {
        Node(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }

        int level;
        TreeNode treeNode;
    }
}
