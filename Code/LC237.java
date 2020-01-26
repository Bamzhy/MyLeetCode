package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 */
public class LC237 {
    // here is the best solution I have ever met
    // replace the next node with the node
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
    }
}
