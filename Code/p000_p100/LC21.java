package com.bamzhy.My_LeetCode.Code.p000_p100;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class LC21 {
    // more advanced edition
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoListsBamzhy(ListNode l1, ListNode l2) {
        // autually we can use l1/l2 directly
        ListNode headA = l1;
        ListNode headB = l2;

        ListNode res = new ListNode(0);
        ListNode dummyHead = res;

        // if locally is not asked , use a extra space is more easier to solve the problem
        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                ListNode temp = new ListNode(headA.val);
                dummyHead.next = temp;
                dummyHead = temp;
                headA = headA.next;
            } else {
                ListNode temp = new ListNode(headB.val);
                dummyHead.next = temp;
                dummyHead = temp;
                headB = headB.next;
            }
        }

        if (headA != null) {
            dummyHead.next = headA;
        }
        if (headB != null) {
            dummyHead.next = headB;
        }
        return res.next;
    }

    public ListNode mergeTwoListsBamzhySimplified(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode dummyHead = res;

        // if locally is not asked , use a extra space is more easier to solve the problem
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummyHead.next = l1;
                dummyHead = l1;
                l1 = l1.next;
            } else {
                dummyHead.next = l2;
                dummyHead = l2;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            dummyHead.next = l2;
        }else{
            dummyHead.next = l1;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode listNode1 = new ListNode(arr1);
        ListNode listNode2 = new ListNode(arr2);
        System.out.println(listNode1.toString());
        System.out.println(listNode2.toString());
        System.out.println(new LC21().mergeTwoLists(listNode1, listNode2).toString());
    }
}
