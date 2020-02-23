package com.bamzhy.My_LeetCode.Code.p101_p200;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class LC131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if (s == null || s.length() == 0) return list;

        return doPartition(s, 0);
    }

    private List<List<String>> doPartition(String s, int start) {
        // 递归的出口，空字符串
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            String left = s.substring(start, i + 1);
            System.out.println("-----------left:"+left);
            if (isPalindrome(left)) {
                for (List<String> a : doPartition(s, i + 1)) {
                    a.add(0, left);
                    ans.add(a);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String left) {
        if (left == null || left.length() <= 1) return true;
        int i = 0;
        while (i < (left.length() - i -1 )) {
            if (left.charAt(i) != left.charAt(left.length() - i -1 ))
                return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        new LC131().partition("aabbccdd");
    }
}
