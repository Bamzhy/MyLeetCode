package com.bamzhy.My_LeetCode.Code.p101_p200;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

import java.util.HashMap;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */
public class LC141 {
    // 快慢指针做法
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = head;
        ListNode slow = pre;

        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            slow = slow.next;
        }
        return false;
    }



    // 普通做法
    public boolean hasCycle1(ListNode head) {
        HashMap<ListNode, Boolean> tempMap = new HashMap<>();
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        while (preHead.next != null) {
            ListNode node = preHead.next;
            if (tempMap.containsKey(node)) {
                return true;
            }
            tempMap.put(node, true);
            preHead = preHead.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        ListNode node = new ListNode(a);
        System.out.println(new LC141().hasCycle(node));
    }

}
