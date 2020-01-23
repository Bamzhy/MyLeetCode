package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 */
public class LC2 {
    public ListNode addTwoNumbersLeetCode(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbersLeetCodeRepeat(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode res = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = (l1 != null ? l1.val : 0);
            int b = (l2 != null ? l2.val : 0);
            int val = a + b + carry;
            res.next = new ListNode(val % 10);
            res = res.next;
            carry = val / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbersBamzhy(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode dummyHead = resNode;
        int temp = 0;
        // simple situation
        while (l1 != null && l2 != null) {
            int cacuVal = l1.val + l2.val + temp;
            temp = cacuVal / 10;
            dummyHead.next = new ListNode(cacuVal % 10);
            dummyHead = dummyHead.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // temp represents carrying
        // if we didn't solve it carrying ,there will be a mistake
        while (temp != 0) {
            if (l1 == null) {
                if (l2 != null) {
                    int cacuVal = l2.val + temp;
                    temp = cacuVal / 10;
                    dummyHead.next = new ListNode(cacuVal % 10);
                    dummyHead = dummyHead.next;
                    l2 = l2.next;
                } else {
                    dummyHead.next = new ListNode(temp);
                    dummyHead = dummyHead.next;
                    break;
                }
            } else {
                int cacuVal = l1.val + temp;
                temp = cacuVal / 10;
                dummyHead.next = new ListNode(cacuVal % 10);
                dummyHead = dummyHead.next;
                l1 = l1.next;
            }
        }
        // whether l1 or l2 is not ended
        if (l1 == null) {
            dummyHead.next = l2;
        } else {
            dummyHead.next = l1;
        }
        return resNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        ListNode listNode1 = new ListNode(arr1);
        ListNode listNode2 = new ListNode(arr2);
        System.out.println(listNode1.toString());
        System.out.println(listNode2.toString());
        System.out.println(new LC2().addTwoNumbersLeetCodeRepeat(listNode1, listNode2).toString());
    }
}
