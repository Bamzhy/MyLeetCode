package com.bamzhy.My_LeetCode.Pojo;

import java.util.LinkedList;

public class TreeNodeUtils {

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
}
