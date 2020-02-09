package com.bamzhy.My_LeetCode.Code.p000_p100;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Medium Level
 */
public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode start = dummyHead;

        // find the node which located before the node started to traverse
        for (int i = 1; i < m; i++) {
            start = start.next;
        }

        ListNode traverseCur = start.next;
        ListNode pre = null;

        // traverse the linkedList from m to n
        // at the end of cycle, 'ListNode next' pointed the first normal listNode
        // and 'ListNode pre' pointed to all nodes traversed
        int tag = m;
        while (tag <= n) {
            ListNode next = traverseCur.next;
            traverseCur.next = pre;
            pre = traverseCur;
            traverseCur = next;
            tag++;
        }

//        //this is nore visual than the method above
//        for (int i = m; i <= n; i++) {
//            ListNode next = traverseCur.next;
//            traverseCur.next = pre;
//            pre = traverseCur;
//            traverseCur = next;
//        }

        // here is the most important area
        // 'ListNode start.next.next' means the last node be traversed
        start.next.next = traverseCur;
        start.next = pre;

        return dummyHead.next;
    }

    // a wrong try, don't follow me
    public ListNode reverseBetweenBamzhy(ListNode head, int m, int n) {
        // first do traverse to get the node before m ,then get the node after n
        if (head == null) return null;

        int tag = 1;
        ListNode start = null;
        ListNode end = null;
        ListNode temp = new ListNode(0);
        temp.next = head;
        while (temp != null) {
            ++tag;
            if (tag == m) {
                start = temp;
            }
            if (tag == n) {
                end = temp;
            }
            temp = temp.next;
        }

        // do reverse
        ListNode pre = null;
        ListNode cur = start;
        while (cur.next != null && cur != end) {
            ListNode next = cur.next;
            pre = cur;
            cur = next;
            cur.next = pre;
        }

        // connect all nodes
        start.next = end;

        int tag2 = 1;
        ListNode temp2 = head;
        while (tag2 < n) {
            temp2 = temp2.next;
            tag2++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {5};
        ListNode node = new ListNode(arr);
        System.out.println(node);
        System.out.println(new LC92().reverseBetween(node, 1, 1));

    }
}
