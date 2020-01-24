package com.bamzhy.My_LeetCode.LeetCode;

import java.util.HashSet;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /.
 * Each operand may be an integer or another expression.
 */
public class LC150 {
    public int evalRPNBest(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num = stack.pop();
                    stack.push(stack.pop() / num);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }

    public int evalRPN(String[] tokens) {
        HashSet<String> charSet = new HashSet<>();
        Stack<String> tempStack = new Stack<>();

        charSet.add("+");
        charSet.add("-");
        charSet.add("*");
        charSet.add("/");

        // actually we can unify handling character and calculating at a time
        for (String a : tokens) {
            if (charSet.contains(a)) {
                String temp = doCaculate(tempStack.pop(), tempStack.pop(), a);
                tempStack.add(temp);
            }else{
                tempStack.add(a);
            }
        }
        return Integer.valueOf(tempStack.peek());
    }

    private String doCaculate(String pop1, String pop2, String a) {
        switch (a) {
            case "+":
                return String.valueOf(Integer.valueOf(pop2) + Integer.valueOf(pop1));
            case "-":
                return String.valueOf(Integer.valueOf(pop2) - Integer.valueOf(pop1));
            case "*":
                return String.valueOf(Integer.valueOf(pop2) * Integer.valueOf(pop1));
            case "/":
                return String.valueOf(Integer.valueOf(pop2) / Integer.valueOf(pop1));
        }
        return "0";
    }

    public static void main(String[] args) {
        String[] a = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new LC150().evalRPN(a));
    }
}
