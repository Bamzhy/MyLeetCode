package com.bamzhy.My_LeetCode.Code.target_of_offer;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.HashMap;

/**
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-17
 */
public class tof07 {
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int pre_root, int in_left, int in_right) {
        // 子树的中序遍历为空，说明已经越过叶子节点
        if (in_left > in_right) return null;
        TreeNode root = new TreeNode(po[pre_root]);
        // 因为节点的值不重复，这样可以找出root节点在inOrder数组中的位置
        int i = dic.get(po[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        // 右子树根节点index = root索引index + 左子树长度 + 1
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }
}
