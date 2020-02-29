package com.bamzhy.My_LeetCode.Code.p201_p300;

import java.util.LinkedList;
/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 我的题解
 * https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-de-jian-yi-javati-jie-c/
 */
public class LC225 {

    LinkedList<Integer> queue;
    public LC225() {
        queue = new LinkedList<>();
    }
    public void push(int x) {
        queue.addLast(x);
    }
    public int pop() {
        return queue.removeLast();
    }
    public int top() {
        return queue.getLast();
    }
    public boolean empty() {
        return queue.size() == 0;
    }
}
