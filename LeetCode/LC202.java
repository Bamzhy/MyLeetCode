package com.bamzhy.My_LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

/* the most important thing
   make sure which situation to stop
   1 temp < 10 and temp !=1
   2 a set which stores temp number contains duplicate values
 */
public class LC202 {
    public boolean isHappyBobo(int n) {
        HashSet<Integer> record = new HashSet<>();
        record.add(n);
        while (n != 1) {
            n = op(n);
            if (record.contains(n)) {
                return false;
            } else {
                record.add(n);
            }
        }
        return true;
    }

    public int op(int n) {
        int res = 0;
        while (n > 0) {
            int t = n % 10;
            n = n / 10;
            res += t * t;
        }
        return res;
    }


    public boolean isHappyBamzhy(int n) {
        int temp = transferNumber(n);
        while (temp != 1) {
            temp = transferNumber(temp);
            if (temp < 10 && temp != 1) {
                return false;
            }
        }
        return true;
    }

    private int transferNumber(int n) {
        Stack<Integer> tempList = new Stack<>();
        while (n > 0) {
            tempList.add(n % 10);
            n = n / 10;
        }
        int result = 0;
        while (!tempList.empty()) {
            Integer pop = tempList.pop();
            result += pop * pop;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC202().isHappyBamzhy(19));
    }
}
