package com.bamzhy.My_LeetCode.Code.p101_p200;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */
public class LC121 {

    public int maxProfitRough(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (j > i && prices[j] > prices[i]) {
                    res.add(prices[j] - prices[i]);
                }
            }
        }

        Collections.sort(res);
        if (res.size() == 0) return 0;
        int val = res.get(res.size() - 1);
        return val < 0 ? 0 : val;
    }

    //时间复杂度：O(n2)
    //空间复杂度：O(1)
    public int maxProfitRoughButMoreGraceful(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }

        return res;
    }

    public int maxProfitBest(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int res = 0;
        int minVal = prices[0];

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }

        return res;
    }

}
