package com.bamzhy.My_LeetCode.Code;

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

    public ListNode swapPairsBamzhy(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        ListNode next = cur.next;

        while (next != null) {
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            next = cur;
            cur = pre.next;

            if (next.next == null)
                break;
            else {
                pre = pre.next.next;
                cur = cur.next.next;
                next = next.next.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        // use p as the headnode
        // so we needn't adjust the cur pointer and the next pointer
        while (p.next != null && p.next.next != null) {
            ListNode pre = p;
            ListNode cur = pre.next;
            ListNode next = cur.next;

            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            p = p.next.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 1, 2, 2};
        ListNode node = new ListNode(array);
        System.out.println(node.toString());
        System.out.println(new LC24().swapPairs(node).toString());
    }
}
