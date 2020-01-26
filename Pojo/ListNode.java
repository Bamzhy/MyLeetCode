package com.bamzhy.My_LeetCode.Pojo;

/**
 * Definition for singly-linked list
 * Contains assist methods
 *
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode e) {
        val = x;
        next = e;
    }

    public ListNode() {}

    // create a linkedList by array[n]
    // int[] arr is an constructor 's parameter
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array Cannot Be Empty!");
        }
        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curNode = this;
        while (curNode != null) {
            sb.append(curNode.val);
            sb.append(" -> ");
            curNode = curNode.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}

