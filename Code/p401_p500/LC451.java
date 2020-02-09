package com.bamzhy.My_LeetCode.Code.p401_p500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class LC451 {
    public String frequencySortBest(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int[] count_copy = Arrays.copyOf(count, count.length);
        Arrays.sort(count);

        StringBuilder sb = new StringBuilder();
        // traverse the count array in a reverse order
        for (int i = count.length - 1; i >= 0 && count[i] > 0; i--) {
            for (int j = 0; j < count_copy.length; j++) {
                if (count[i] == count_copy[j]) {
                    while (count_copy[j]-- > 0) {
                        sb.append((char) j);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String frequencySortBamzhy(String s) {
        // use a HashMap to store all character's frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (char a : map.keySet()) {
            list.add(map.get(a));
        }
        Collections.sort(list);

        // generate String by frequency list
        StringBuilder sb = new StringBuilder();
        for (int a : list) {
            char b = 0;
            for (char c : map.keySet()) {
                b = c;
                if (map.get(c) == a) {
                    for (int i = 0; i < a; i++) {
                        sb.append(c);
                    }
                    break;
                }
            }
            map.remove(b);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LC451().frequencySortBamzhy("asddddddqqwwssxxccvb"));
    }
}
