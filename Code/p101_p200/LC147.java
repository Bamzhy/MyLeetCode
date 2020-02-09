package com.bamzhy.My_LeetCode.Code.p101_p200;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

/**
 * Sort a linked list using insertion sort.
 */
public class LC147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead.next;
        ListNode q = p.next;
        p.next = null;

        // q traverse the linkedList
        while (q != null) {
            while (p.val < q.val) {
                p = p.next;

            }

            q = q.next;
        }
        return dummyHead.next;

    }
}
