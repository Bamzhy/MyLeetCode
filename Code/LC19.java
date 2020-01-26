package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

public class LC19 {
    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     */
    /*
     n is started from 0 or started from 1 ? if n is not legal, how to deal with it

     my idea: time O(n) space O(1)
        traverse the linkedList and get the list's length
        set a tag ,and do traverse until the tag is equals to length - n
        delete the node
     better idea:
        make two points, first is pointed to the dummyNode,
        and make second point has 'n+1' distance from the first point
        do traverse, until second point pointed to null
        delete first node's next node
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null) return null;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        // q node traverse n's times
        for (int i = 0; i < n + 1; i++) {
            if (q != null) {
                q = q.next;
            }
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1};
        ListNode listNode1 = new ListNode(arr1);
        System.out.println(listNode1.toString());
        System.out.println(new LC19().removeNthFromEnd(listNode1, 1).toString());
    }
}
