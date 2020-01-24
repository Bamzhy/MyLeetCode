package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 */
public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = pre.next;
        ListNode next = cur.next;

        while (next != null) {
            while (cur.val == next.val && next != null) {
                next = next.next;
            }
            cur.next = next.next;
            pre = pre.next;
            cur = cur.next;
            next = next.next;
        }
        return dummyHead.next;
    }
}
