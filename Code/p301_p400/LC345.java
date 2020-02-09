package com.bamzhy.My_LeetCode.Code.p301_p400;

public class LC345 {
    public static void main(String[] args) {
        System.out.println(new LC345().reverseVowelsLiuYuBo("leetcode"));
    }

    public String reverseVowelsLiuYuBo(String s) {
        if (s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int i = nextVowelIndex(chars, 0);
        int j = preVowelIndex(chars, chars.length - 1);
        while (i < j) {
            swap(chars, i, j);
            i = nextVowelIndex(chars, i + 1);
            j = preVowelIndex(chars, j - 1);
        }
        return new String(chars);
    }

    private int nextVowelIndex(char[] s, int i) {
        for (int j = i; j < s.length; j++) {
            char c = Character.toLowerCase(s[j]);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return j;
            }

        }
        return s.length - 1;

    }

    private int preVowelIndex(char[] s, int i) {
        for (int j = i; j > 0; j--) {
            char c = Character.toLowerCase(s[j]);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return j;
            }

        }
        return 0;
    }


    // a e i o u
    // 逼着你使用对撞指针(双指针)法
    public String reverseVowelsBamzhy(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u' || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U') {
                if (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u' || chars[j] == 'A' || chars[j] == 'E' || chars[j] == 'I' || chars[j] == 'O' || chars[j] == 'U') {
                    swap(chars, i, j);
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }

        }
        StringBuilder temp = new StringBuilder();
        for (char a : chars) {
            temp.append(a);
        }
        return temp.toString();
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
