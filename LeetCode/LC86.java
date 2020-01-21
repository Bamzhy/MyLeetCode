package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.ListNode;

/**
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class LC86 {
    public ListNode partitionBamzhy1(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode lefttemp = left;
        ListNode righttemp = right;

        ListNode travse = head;

        // generate left and right linkedList
        while (travse != null) {
            if (travse.val < x) {
                lefttemp.next = travse;
                lefttemp = lefttemp.next;

            } else {
                righttemp.next = travse;
                righttemp = righttemp.next;
            }
            travse = travse.next;
        }

        righttemp.next = null;
        lefttemp.next = right.next;
        return left.next;
    }

    public ListNode partitionBamzhy2(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode lefttemp = left;
        ListNode righttemp = right;

        ListNode travse = head;

        // generate left and right linkedList
        while (travse != null) {
            if (travse.val < x) {
                lefttemp.next = new ListNode(travse.val);
                lefttemp = lefttemp.next;

            } else {
                righttemp.next = new ListNode(travse.val);
                righttemp = righttemp.next;
            }
            travse = travse.next;
        }

//        // get left NodeList's last node
//        // actually it is meaningless because lefttemp stored the information we need
//        ListNode temp = left;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = right.next;
        lefttemp.next = right.next;
        return left.next;
    }

    public ListNode partition(ListNode head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 4, 3, 5, 7, 10, 2};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode.toString());
        System.out.println(new LC86().partition(listNode, 5).toString());
    }
}
