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
        int[] arr = {1,2,3,4,5};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode.toString());
        System.out.println(new LC206().reverseList(listNode).toString());
    }

}
