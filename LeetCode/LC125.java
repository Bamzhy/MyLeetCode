package com.bamzhy.My_LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LC125 {
    public static boolean isPalindromeLeetCode(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                chars[cnt++] = c;
            } else if (c >= 'A' && c <= 'Z') {
                chars[cnt++] = (char) (c - 'A' + 'a');
            }
        }
        cnt--;
        while (cnt > j) {
            if (chars[cnt--] != chars[j++]) {
                return false;
            }
        }
        return true;
    }

    //验证它是否是回文串1
    public boolean isPalindromeBamzhy1(String s) {
        if (s.length() == 0) return true;
        HashMap<String, String> toolMap = initMap();
        ArrayList<String> list = new ArrayList<>();
        String[] split = s.split("");
        for (String a : split) {
            for (String b : toolMap.keySet()) {
                if (a.equals(b)) {
                    list.add(toolMap.get(b));
                }
            }
        }
        int tag = 0;
        if (list.size() == 0)
            return true;
        else {
            int size = list.size();
            for (int i = 0; i < size / 2; i++) {
                if (!list.get(i).equals(list.get(size - i - 1))) {
                    tag++;
                }
            }
        }

        return tag == 0;
    }

    private HashMap<String, String> initMap() {
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("A", "a");
        resultMap.put("B", "b");
        resultMap.put("C", "c");
        resultMap.put("D", "d");
        resultMap.put("E", "e");
        resultMap.put("F", "f");
        resultMap.put("G", "g");
        resultMap.put("H", "h");
        resultMap.put("I", "i");
        resultMap.put("J", "j");
        resultMap.put("K", "k");
        resultMap.put("L", "l");
        resultMap.put("M", "m");
        resultMap.put("N", "n");
        resultMap.put("O", "o");
        resultMap.put("P", "p");
        resultMap.put("Q", "q");
        resultMap.put("R", "r");
        resultMap.put("S", "s");
        resultMap.put("T", "t");
        resultMap.put("U", "u");
        resultMap.put("V", "v");
        resultMap.put("W", "w");
        resultMap.put("X", "x");
        resultMap.put("Y", "y");
        resultMap.put("Z", "z");
        resultMap.put("a", "a");
        resultMap.put("b", "b");
        resultMap.put("c", "c");
        resultMap.put("d", "d");
        resultMap.put("e", "e");
        resultMap.put("f", "f");
        resultMap.put("g", "g");
        resultMap.put("h", "h");
        resultMap.put("i", "i");
        resultMap.put("j", "j");
        resultMap.put("k", "k");
        resultMap.put("l", "l");
        resultMap.put("m", "m");
        resultMap.put("n", "n");
        resultMap.put("o", "o");
        resultMap.put("p", "p");
        resultMap.put("q", "q");
        resultMap.put("r", "r");
        resultMap.put("s", "s");
        resultMap.put("t", "t");
        resultMap.put("u", "u");
        resultMap.put("v", "v");
        resultMap.put("w", "w");
        resultMap.put("x", "x");
        resultMap.put("y", "y");
        resultMap.put("z", "z");
        resultMap.put("0", "0");
        resultMap.put("1", "1");
        resultMap.put("2", "2");
        resultMap.put("3", "3");
        resultMap.put("4", "4");
        resultMap.put("5", "5");
        resultMap.put("6", "6");
        resultMap.put("7", "7");
        resultMap.put("8", "8");
        resultMap.put("9", "9");

        return resultMap;
    }

    public boolean isPalindromeBamzhy2(String s) {
        if (s.length() == 0) return true;
        char[] aim = s.toCharArray();
        int i = 0;
        for (char a : aim) {
            if (a >= 'a' && a <= 'z' || a >= '0' && a <= '9') {
                aim[i++] = a;
            } else if (a >= 'A' && a <= 'Z') {
                aim[i++] = (char) (a + 'a' - 'A');
            }

        }
        i--;
        System.out.println(Arrays.toString(aim));
        //aim的0-i中包含了干净的、不含大写的字符
        for (int k = 0; k < (i + 1) / 2; k++) {
            if (aim[k] != aim[i - k]) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        new LC125().isPalindromeBamzhy2("race a car");
    }
}
