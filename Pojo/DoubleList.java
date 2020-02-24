package com.bamzhy.My_LeetCode.Pojo;

/**
 * 双向链表的定义
 */
public class DoubleList {
    public class Node {
        public int key, val;
        public Node next, prev;

        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    private Node head, tail;// 头尾虚节点
    private int size;//链表元素数

    // 初始化
    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在双链表头部添加节点x
    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    // 在双链表删除节点x x一定存在
    // 删除操作需要用到双向链表，因为删除一个节点不光光要得到该节点本身的指针
    // 还需要得到其前驱节点的指针，双向链表才能保证删除操作时O(1)的
    public void remove(Node x) {
        x.prev.prev = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeLast() {
        if (tail.prev == head)
            return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }
}
