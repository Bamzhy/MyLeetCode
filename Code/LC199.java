package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class LC199 {
    class LevelOrderNode {
        int level;
        TreeNode node;

        LevelOrderNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tempArray = new ArrayList<>();
        LinkedList<LevelOrderNode> queue = new LinkedList<>();


        if (root == null) return res;

        queue.push(new LevelOrderNode(0, root));

        while (queue.size() > 0) {
            LevelOrderNode node = queue.removeFirst();
            int level = node.level;
            TreeNode treeNode = node.node;
            if (level == tempArray.size()) {
                tempArray.add(new ArrayList<>());
            }
            tempArray.get(level).add(treeNode.val);
            if (treeNode.left != null)
                queue.addLast(new LevelOrderNode(level + 1, treeNode.left));
            if (treeNode.right != null)
                queue.addLast(new LevelOrderNode(level + 1, treeNode.right));
        }

        for (ArrayList<Integer> a : tempArray) {
            if (a.size() > 0) {
                res.add(a.get(a.size() - 1));
            }
        }
        return res;
    }
}
