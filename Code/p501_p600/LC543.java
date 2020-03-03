package com.bamzhy.My_LeetCode.Code.p501_p600;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class LC543 {
    /**
     * 错误理解：树的最大直径只存在于两个叶子节点的距离集合中，这样复杂化了
     * 正确理解：每个节点都是一棵树，节点的直径等于左子树的高度+右子树的高度
     */
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
