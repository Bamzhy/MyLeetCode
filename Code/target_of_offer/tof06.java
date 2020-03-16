package com.bamzhy.My_LeetCode.Code.target_of_offer;

import com.bamzhy.My_LeetCode.Pojo.ListNode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-16
 */
public class tof06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int[] res;
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        if (stack.size() == 0)
            res = new int[0];
        else {
            int i = 0;
            res = new int[stack.size()];
            while (stack.size() > 0) {
                res[i++] = stack.pop();
            }
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int[] res;
        while (head != null) {

            head = head.next;
        }

        if (stack.size() == 0)
            res = new int[0];
        else {
            int i = 0;
            res = new int[stack.size()];
            while (stack.size() > 0) {
                res[i++] = stack.pop();
            }
        }
        return res;
    }
}
