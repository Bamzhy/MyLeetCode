package com.bamzhy.My_LeetCode.Code.p201_p300;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */
public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
        }

        List<String> leftList = binaryTreePaths(root.left);
        for (String a:leftList) {
            res.add(root.val+"->"+a);
        }
        List<String> rightList = binaryTreePaths(root.left);
        for (String a:rightList) {
            res.add(root.val+"->"+a);
        }

        return res;
    }
}
