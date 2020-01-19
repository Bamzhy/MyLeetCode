package com.bamzhy.My_LeetCode.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LC242 {
    public static void main(String[] args) {
        String a = "a";
        String b = "ab";
        System.out.println(isAnagram1(a, b));
    }

    // 使用Map的办法
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (char a : map1.keySet()) {
            if (!map2.containsKey(a) || (map1.get(a).compareTo(map2.get(a)) != 0)) {
                return false;
            }
        }
        return true;
    }

    // 排序
    public boolean isAnagram2(String s, String t) {


        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }

    // 使用Hash表
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        int[] s1A = new int[26];
        int[] t1A = new int[26];

        for (char i : s1) {
            s1A[i - 'a']++;
        }
        for (char i : t1) {
            t1A[i - 'a']++;
        }

        return Arrays.equals(s1A, t1A);
    }
}
