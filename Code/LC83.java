package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

public class LC83 {
    /**
     * Given a sorted linked list,
     * delete all duplicates such that each element appear only once.
     */
    public ListNode deleteDuplicates(ListNode head) {
        // a habit , I usually use a dummy headnode
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // there is a trap, if head.val == head.next.val
        // make head.next = head.next.next
        // you shouldn't move the head,
        // continue make a compare between head.val and head.next.val
        // until head.val != head.next.val
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode.toString());
        System.out.println(new LC83().deleteDuplicates(listNode).toString());
    }
}
