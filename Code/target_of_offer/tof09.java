package com.bamzhy.My_LeetCode.Code.target_of_offer;

import java.util.Stack;

/**
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-10
 */
public class tof09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public tof09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() > 0)
            return stack2.pop();
        else {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
            if (stack2.size() > 0)
                return stack2.pop();
            else
                return -1;
        }
    }
}
