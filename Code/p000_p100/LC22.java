package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class LC22 {
    List<String> res;
    int length;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        length = 2 * n;
        Stack<String> tempStack = new Stack<>();

        if (n <= 0) return res;

        doGenerate(n, "", tempStack);
        return res;
    }

    private void doGenerate(int n, String s, Stack<String> tempStack) {
        if (s.length() == length) {
            tempStack.clear();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    tempStack.push("(");
                else {
                    if (tempStack.size() == 0) {
                        tempStack.add("");
                        break;
                    } else
                        tempStack.pop();
                }
            }
            if (tempStack.size() == 0) {
                res.add(s);
            }
            return;
        }
        doGenerate(n - 1, s + "(", tempStack);
        doGenerate(n - 1, s + ")", tempStack);
    }

    public static void main(String[] args) {
        List<String> strings = new LC22().generateParenthesis(3);
        System.out.println(strings);
    }
}
