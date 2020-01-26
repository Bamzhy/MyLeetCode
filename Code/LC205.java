package com.bamzhy.My_LeetCode.Code;

import java.util.HashMap;

public class LC205 {
    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     */
    public boolean isIsomorphicBamzhy(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if (sArr.length != tArr.length) {
            return false;
        }
        if (sArr.length == 0 && tArr.length == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(sArr[0], tArr[0]);
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i - 1] != (sArr[i])) {
                if (tArr[i - 1] == (tArr[i])) {
                    return false;
                }
                map.put(sArr[i - 1], tArr[i - 1]);
            }
        }
        map.put(sArr[sArr.length - 1], tArr[tArr.length - 1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            sb.append(map.get(s.charAt(i)));
        }
        return t.equals(sb.toString());
    }

    /**
     * 方法非常的巧，同一个字符应该在相似的位置，如果出现index不同，表示并不是同一个字符
     * 需要自己敲一遍
     */

  public boolean isIsomorphic1(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 每次用 map 检查是否出现了同一个key对应了不同值
     */
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);

    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LC205().isIsomorphicBamzhy("egg", "add"));
        System.out.println(new LC205().isIsomorphicBamzhy("foo", "bar"));
    }
}

