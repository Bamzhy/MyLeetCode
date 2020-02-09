package com.bamzhy.My_LeetCode.Code.p201_p300;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

public class LC203 {
    public ListNode removeElementsWithDummyHead(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null) {
            // do delete
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;

        // a lot of problems need to be concerned because of the head node
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            // head = head.next
        }
        if (head == null) return null;

        while (cur.next != null) {
            // do delete
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode.toString());
        System.out.println(new LC203().removeElementsWithDummyHead(listNode, 6));
    }
}
