package com.bamzhy.My_LeetCode.Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 */
public class LC71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String a : split) {
            if (a != null && !a.equals("")) {
                if (a.equals("..")) {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                } else {
                    if (!a.equals(".")) {
                        stack.add(a);
                    }
                }
            }
        }
        ArrayList<String> list = new ArrayList<>(stack);
        StringBuilder sb = new StringBuilder();
        for (String a : list) {
            sb.append("/").append(a);
        }
        String res = sb.toString();
        return res.length() == 0 ? "/" : res;
    }

    public String simplifyPathLeetCode(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] paths = path.split("/");

        for (String s : paths) {
            if (s.equals("..")) {
                if (stack.size() > 0)
                    stack.pop();
            } else {
                if (!s.equals(".") && !s.equals(""))
                    stack.push(s);
            }

        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append("/" + stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String a = "/../";
        System.out.println(new LC71().simplifyPath(a));
    }
}
