package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class LC24 {
    public ListNode swapPairsBest(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null) {
            // the three temp Node is very important
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        ListNode next = dummyHead.next.next;

        while (next.next != null) {
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            next = cur;
            cur = pre.next;

            pre = pre.next.next;
            cur = cur.next.next;
            next = next.next.next;
        }
        return dummyHead.next;
    }
}
