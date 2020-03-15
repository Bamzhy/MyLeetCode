package com.bamzhy.My_LeetCode.Code.target_of_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author bamzhy
 * @version 1.0.0
 * @since 2020-03-10
 */
public class tof05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return "";
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char a : chars) {
            if (a == ' ') {
                list.add('%');
                list.add('2');
                list.add('0');
            } else {
                list.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char a : list) {
            sb.append(a);
        }
        return sb.toString();
    }
}
