package com.bamzhy.My_LeetCode.Code;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 */

public class LC290 {
    public static void main(String[] args) {
        System.out.println(new LC290().wordPattern("abc", "b c a"));
        System.out.println(new LC290().wordPattern("aaaa", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        char[] patternArr = pattern.toCharArray();
        String[] strArr = str.split(" ");
        if (patternArr.length != strArr.length) {
            return false;
        }
        if (patternArr.length == 0 || patternArr.length == 1) return true;
        HashMap<Character, String> map = new HashMap<>();
        map.put(patternArr[0], strArr[0]);
        for (int i = 1; i < patternArr.length; i++) {
            if (patternArr[i - 1] != (patternArr[i])) {
                if (strArr[i - 1].equals(strArr[i])) {
                    return false;
                }
                map.put(patternArr[i - 1], strArr[i - 1]);
            }
        }
        map.put(patternArr[patternArr.length - 1], strArr[strArr.length - 1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            sb.append(map.get(pattern.charAt(i))).append(" ");
        }
        return sb.substring(0, sb.length() - 1).equals(str);
    }

}
