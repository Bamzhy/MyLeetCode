package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 * each number's value of an valid IP address : 0 - 255
 */
public class LC93 {
    int n;
    String s;
    List<String> outPut = new ArrayList<>();
    LinkedList<String> segments = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        this.n = s.length();
        this.s = s;
        backTrack(-1, 3);
        return outPut;
    }

    private void backTrack(int prev_pos, int dots) {
        int maxPos = Math.min(n - 1, prev_pos + 4);
        for (int currPos = prev_pos + 1; currPos < maxPos; currPos++) {
            String segemnt = s.substring(prev_pos + 1, currPos + 1);
            System.out.println("this is a segement " + segemnt);
            if (valid(segemnt)) {
                segments.add(segemnt);
                if (dots - 1 == 0)
                    updateOutput(currPos);
                else
                    backTrack(currPos, dots - 1);
                segments.removeLast();
            }
        }

    }

    private boolean valid(String segemnt) {
        int m = segemnt.length();
        if (m > 3)
            return false;
        return (segemnt.charAt(0) == '0') ? (m == 1) : (Integer.valueOf(segemnt) <= 255);
    }

    private void updateOutput(int currPos) {
        String segement = s.substring(currPos + 1, n);

        if (valid(segement)) {
            segments.add(segement);
            outPut.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC93().restoreIpAddresses("25525511135"));
    }
}
