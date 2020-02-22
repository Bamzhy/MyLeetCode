package com.bamzhy.My_LeetCode.Code.p000_p100;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class LC91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        if (start == s.length())
            return 1;
        if (s.charAt(start) == '0')
            return 0;
        // 第一个数字肯定在A-Z中
        int a = getAns(s, start + 1);
        int b = 0;

        // 确认前两个数字是否小于等于26
        if (start < s.length() - 1) {
            if ((s.charAt(start) - '0') * 10 + (s.charAt(start + 1) - '0') <= 26) {
                b = getAns(s, start + 2);
            }
        }

        return a + b;
    }
}
