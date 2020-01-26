package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * do preorder traverse to a binary tree
 */
public class LC144 {
    class Command {
        String tag;
        TreeNode node;

        Command(String tag, TreeNode node) {
            this.tag = tag;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversalNoRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Command> stack = new Stack<>();

        if (root == null) return res;

        stack.push(new Command("go", root));
        while (stack.size() > 0) {
            Command pop = stack.pop();
            if (pop.tag.equals("go")) {
                if (pop.node.right != null)
                    stack.push(new Command("go", pop.node.right));
                if (pop.node.left != null)
                    stack.push(new Command("go", pop.node.left));
                stack.push(new Command("add", pop.node));
            } else {
                res.add(pop.node.val);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> tempInt = new ArrayList<>();
        doPreorder(root, tempInt);
        return tempInt;
    }

    private void doPreorder(TreeNode root, ArrayList<Integer> tempInt) {
        if (root != null) {
            tempInt.add(root.val);
            doPreorder(root.left, tempInt);
            doPreorder(root.right, tempInt);
        }
    }

}
