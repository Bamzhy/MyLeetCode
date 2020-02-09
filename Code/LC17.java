package com.bamzhy.My_LeetCode.Code;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LC17 {
    static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> res;

    public List<String> letterCombinationsRepeat(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        generateCombination(digits, 0, "");
        System.out.println(res);
        return res;
    }

    private void generateCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        String letter = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            generateCombination(digits, index + 1, s + letter.charAt(i));
        }
    }

//    public List<String> letterCombinations(String digits) {
//        res = new ArrayList<>();
//        if (digits == null || digits.length() == 0) return res;
//        findCombination(digits, 0, "");
//        return res;
//    }
//
//    private void findCombination(String digits, int index, String s) {
//        System.out.println(index + ": " + s);
//        if (index == digits.length()) {
//            res.add(s);
//            System.out.println("we got " + s + " as a result");
//            return;
//        }
//        char c = digits.charAt(index);
//        String letters = letterMap[c - '0'];
//        for (int i = 0; i < letters.length(); i++) {
//            System.out.println("digits[" + index + "] = " + c + " , use " + letters.charAt(i));
//            findCombination(digits, index + 1, s + letters.charAt(i));
//        }
//        System.out.println("--------digits[" + index + "] = " + c + " is complete, then we return --------");
//    }


    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = map[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        new LC17().letterCombinationsRepeat("234");
    }

    // a failed attempt of violent solution
    // it can not be solved by simple cycles because it's length is unknown (n)
    public List<String> letterCombinationsBamzhy(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        ArrayList<char[]> temp = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String letter = map[c - '0'];
            char[] tempChar = new char[letter.length()];
            for (int j = 0; j < letter.length(); j++) {
                tempChar[j] = letter.charAt(j);
            }
            temp.add(tempChar);
        }

        for (int i = temp.size() - 1; i > 0; i--) {
            char[] arr = temp.get(i);
            if (i - 1 > 0) {
            }
        }
        return res;
    }
}
