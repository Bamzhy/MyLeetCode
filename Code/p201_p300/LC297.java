package com.bamzhy.My_LeetCode.Code.p201_p300;

import com.bamzhy.My_LeetCode.Pojo.TreeNode;

import java.util.LinkedList;

/**
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class LC297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.removeFirst();
            if (node == null)
                sb.append("null,");
            else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] values = data.split(",");
        if (values[0].equals("null")) return null;

        // list只存头节点
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = createNode(values[0]);
        list.add(root);

        int rootIndex = 0;
        int valueIndex = 1;

        while (rootIndex < list.size()) {
            TreeNode node = list.get(rootIndex++);
            if (valueIndex < values.length) {
                node.left = createNode(values[valueIndex++]);
                node.right = createNode(values[valueIndex++]);
            }
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);
        }
        return root;
    }

    private TreeNode createNode(String value) {
        if (value == null || value.equals("null"))
            return null;
        else
            return new TreeNode(Integer.parseInt(value));
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(new LC297().deserialize("1,2,3,null,null,4"));
    }
}
