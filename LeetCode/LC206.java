package com.bamzhy.My_LeetCode.LeetCode;

import com.bamzhy.My_LeetCode.ListNode;

public class LC206 {
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while(cur!=null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // becuase cur is null
        return pre;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new LC206().reverseList(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
