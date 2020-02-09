package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 */
public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() <= 0;
    }

    public static void main(String[] args) {

    }
}
