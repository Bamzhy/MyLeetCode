package com.bamzhy.My_LeetCode.Code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，
 * 请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 */

/**
 * 思路：
 * 1 我们在字符串S中使用双指针中的左右指针技巧，初始化left=right=0，把闭索引区间[left,right]称为一个滑动窗口
 * 2 先不断增加right指针扩大窗口，直到字符串符合要求，包含了T中所有字符
 * 3 停止增加right，转而不断增加left指针缩小窗口，直到窗口中字符串不再符合要求，不包含T中所有字符。
 * 4 不符合要求后，循环执行2、3操作直到left到达S的尾部
 */
public class LC76 {
    public static void main(String[] args) {
        System.out.println(new LC76().minWindowLeetCode("ADOBECODEBANC", "ABC"));
    }


    public String minWindowLeetCode(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = dictT.size();
        int l = 0, r = 0;//左右指针 左边指针只在出现符合要求窗口时，为了缩短窗口长度++，右边一直在++直到< s.length()
        int formed = 0;//独立字符个数

        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0, 0};// (window length, left, right)

        while (r < s.length()) {
            char c = s.charAt(r);// 从右边取一个字符
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if (dictT.containsKey(c) && windowCounts.get(c).equals(dictT.get(c))) {
                formed++;// 当前字符在两个map中出现频次相等，formed+1
            }

            while (l <= r && formed == required) {// 如果L<=R且出现符合要求的窗口，我们要缩小他的长度
                if (ans[0] == -1 || r - l + 1 < ans[0]) {// 更新一下ans数组
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                c = s.charAt(l++);
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[1] + ans[0]);
    }

    public String minWindowBamzhy(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
        int L = 0;
        int R = s.length() - 1;

        // 处理一下目标String，去掉其中重复元素
        char[] aimChar = t.toCharArray();
        HashSet<Character> tempSet = new HashSet<>();
        for (char a : aimChar) {
            tempSet.add(a);
        }

        char[] fromChar = s.toCharArray();

        return null;
    }
}
