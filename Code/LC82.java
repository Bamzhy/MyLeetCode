package com.bamzhy.My_LeetCode.Code;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 */
public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = new ListNode(Integer.MAX_VALUE);
        ListNode res = cur;
        cur.next = head;

        /* I am confused because different input arrays cause different results
           int[] arr1 = {1, 1, 2, 2, 3, 4, 5}; int[] arr2 = {1, 2, 2, 2, 3, 4, 5, 5, 6};
           The reason why cause different results: We return the head node
           If the head node was linked to the current node , at last we got a modified result
           If not (head node be modified / deleted), we got a unmodified result

           so if the head node is possible to be modified / deleted, don't return head node as result
        */
        while (cur != null && cur.next != null) {
            // when a != b && b != c ,move cur point to the middle place
            cur.next = getNextIndex(cur);
            cur = cur.next;
        }
//        return head;
        return res.next;
    }

    private ListNode getNextIndex(ListNode cur) {
        ListNode next = cur.next;
        while (next.next != null) {
            if (cur.val != next.val && next.val != next.next.val) {
                return next;
            } else {
                cur = cur.next;
                next = next.next;
            }
        }
        // [1,2,3,3] or [1,2,3,4]
        // [1,2,3,3] return null ; [1,2,3,4] return 4
        if (cur.val == next.val)
            return null;
        else
            return next;
    }

    public static void main(String[] args) {
//        int[] arr1 = {1, 1, 2, 2, 3, 4, 5};
//        ListNode node1 = new ListNode(arr1);
//        System.out.println(node1.toString());
//        System.out.println(new LC82().deleteDuplicates(node1).toString());

        System.out.println(" ");
        int[] arr2 = {1, 2, 2, 2, 3, 3, 4, 5, 5, 6};
        ListNode node2 = new ListNode(arr2);
        System.out.println(node2.toString());
        System.out.println(new LC82().deleteDuplicatesLeetCode(node2).toString());
    }

    // quick and slow pointer
    public ListNode deleteDuplicatesLeetCode(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead.next;

        // int[] arr2 = {1, 2, 2, 2, 3, 3, 4, 5, 5, 6};
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast)
                slow = slow.next;
            else
                slow.next = fast.next;
            fast = fast.next;
        }
        return dummyHead.next;
    }
}
