package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class LC94 {
    class Command {
        String tag;
        TreeNode node;

        Command(String tag, TreeNode node) {
            this.tag = tag;
            this.node = node;
        }
    }
    public List<Integer> inorderTraversalNoRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Command> stack = new Stack<>();

        if (root == null) return res;

        stack.push(new Command("go", root));
        while (stack.size() > 0) {
            Command pop = stack.pop();
            if (pop.tag.equals("go")) {
                if (pop.node.right != null)
                    stack.push(new Command("go", pop.node.right));
                stack.push(new Command("add", pop.node));
                if (pop.node.left != null)
                    stack.push(new Command("go", pop.node.left));
            } else {
                res.add(pop.node.val);
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> temp = new ArrayList<>();
        doInorderTraverse(root, temp);
        return temp;
    }

    private void doInorderTraverse(TreeNode root, ArrayList<Integer> temp) {
        if (root != null) {
            doInorderTraverse(root.left,temp);
            temp.add(root.val);
            doInorderTraverse(root.right,temp);
        }
    }
}
