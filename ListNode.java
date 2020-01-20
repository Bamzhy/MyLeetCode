package com.bamzhy.My_LeetCode;

public class ListNode<T> {
    public T val;
    public ListNode next;

    public ListNode(T x) {
        val = x;
    }

    public ListNode(T x, ListNode e) {
        val = x;
        next = e;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
