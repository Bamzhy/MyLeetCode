package com.bamzhy.My_LeetCode.Code;

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
        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode listNode1 = new ListNode(arr1);
        System.out.println(listNode1.toString());
        System.out.println(new LC328().oddEvenList(listNode1).toString());
    }
}
