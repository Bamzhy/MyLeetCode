package com.bamzhy.My_LeetCode.Code.p201_p300;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).
 */
public class LC236 {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return res;
        doTraverse(root, p, q);
        return res;
    }

    private boolean doTraverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        int left = doTraverse(root.left, p, q) ? 1 : 0;
        int right = doTraverse(root.right, p, q) ? 1 : 0;
        int middle = (root.val == p.val || root.val == q.val) ? 1 : 0;

        if (left + right + middle >= 2)
            res = root;

        return left + right + middle > 0;
    }


    // list用来存放所有满足要求的公共节点
    PriorityQueue<Node> list;
    // map用来存放每个节点是否是p或者q的祖先 避免重复查询 存储状态用
    Map<Integer, Map<Integer, Boolean>> map;

    public TreeNode lowestCommonAncestorFailed(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        // 优先级队列 用来把深度更大的节点poll出来
        list = new PriorityQueue<>((o1, o2) -> o2.level - o1.level);
        map = new HashMap<>();
        doLevelTraverse(root, p, q);
        return list.poll().treeNode;
    }

    // 层次遍历
    private void doLevelTraverse(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, root));
        while (queue.size() > 0) {
            Node node = queue.removeFirst();
            // 以当前节点为root节点，在这个子树里寻找p/q节点
            boolean pb = findNode(node.treeNode, p);
            boolean qb = findNode(node.treeNode, q);
            // pb/qb都为true，或当前节点是自身和q节点的公共祖先，或当前节点是自身和p节点的公共祖先时
            // list 加入这个node
            if (pb && qb || (node.treeNode.val == p.val) && qb || (node.treeNode.val == q.val) && pb) {
                list.add(node);
            }
            // 层次遍历过程
            if (node.treeNode.left != null)
                queue.add(new Node(node.level + 1, node.treeNode.left));
            if (node.treeNode.right != null)
                queue.add(new Node(node.level + 1, node.treeNode.right));
        }
    }

    private boolean findNode(TreeNode root, TreeNode p) {
        if (root == null) return false;
        // 如果当前节点里存放了p的状态，直接返回
        if (map.keySet().contains(root.val) && map.get(root.val).keySet().contains(p.val))
            return map.get(root.val).get(p.val);
        if (root.val == p.val) return true;

        boolean left = findNode(root.left, p);
        boolean right = findNode(root.right, p);

        // 往map里存状态
        HashMap<Integer, Boolean> tempMap = new HashMap<>();
        tempMap.put(p.val, left || right);
        map.put(root.val, tempMap);

        return left || right;
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
