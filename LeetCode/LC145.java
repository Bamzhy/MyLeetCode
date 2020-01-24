package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.ListNode;
import com.bamzhy.My_LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class LC145 {
    public static void main(String[] args) {
//        new LC145().postorderTraversalNoRecursive();
    }

    class Command {
        String tag;
        TreeNode node;

        Command(String tag, TreeNode node) {
            this.tag = tag;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversalNoRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Command> stack = new Stack<>();

        if (root == null) return res;

        stack.push(new Command("go", root));
        while (stack.size() > 0) {
            Command pop = stack.pop();
            if (pop.tag.equals("go")) {
                stack.push(new Command("add", pop.node));
                if (pop.node.right != null)
                    stack.push(new Command("go", pop.node.right));
                if (pop.node.left != null)
                    stack.push(new Command("go", pop.node.left));
            } else {
                res.add(pop.node.val);
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> temp = new ArrayList<>();
        doPostorderTraversal(root, temp);
        return temp;
    }

    private void doPostorderTraversal(TreeNode root, ArrayList<Integer> temp) {
        if (root != null) {
            doPostorderTraversal(root.left, temp);
            doPostorderTraversal(root.right, temp);
            temp.add(root.val);
        }
    }
}
