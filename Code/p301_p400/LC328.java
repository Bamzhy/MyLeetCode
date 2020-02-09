package com.bamzhy.My_LeetCode.Code.p301_p400;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place.
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class LC328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode t = dummyHead;
        // mark the middle of the linkList
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        while (slow != null && fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }

        int tag = 0;
        while (p != null && slow != null) {
            if (tag % 2 == 0) {
                t.next = p.next;
                t = t.next;
            } else {
                slow.next = p.next;
                slow = slow.next;
            }
            tag++;
            p = p.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode listNode1 = new ListNode(arr1);
        System.out.println(listNode1.toString());
        System.out.println(new LC328().oddEvenList(listNode1).toString());
    }
}
