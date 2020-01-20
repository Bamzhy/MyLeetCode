package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int tag = 1;
        // do traverse util tag = m ; the do reverse
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (tag >= m && tag <= n) {
                cur.next = pre;
            }
            pre = cur;
            cur = next;
            tag++;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new LC92().reverseBetween(node,2,4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
