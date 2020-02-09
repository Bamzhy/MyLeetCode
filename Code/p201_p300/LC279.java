package com.bamzhy.My_LeetCode.Code.p201_p300;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 */
/* the problem can be transferred into a graph problem;
   from n to 0, each number represents a node
   if x - y is equals to a square number , then connect x and y
   we get a graph without weight
*/
public class LC279 {
    public int numSquaresFirst(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        // value == n step == 0
        queue.add(new Pair<>(n, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.removeFirst();
            int num = node.getKey();
            int step = node.getValue();

            if (num == 0) return step;

            for (int i = 1; num - i * i >= 0; i++) {
                queue.push(new Pair<>(num - i * i, step + 1));
            }
        }

        throw new IllegalArgumentException("No Solution");
    }

    public int numSquaresSecond(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        // value == n step == 0
        boolean[] visited = new boolean[n + 1];
        queue.add(new Pair<>(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.removeFirst();
            int num = node.getKey();
            int step = node.getValue();

            for (int i = 1; ; i++) {
                int a = num - i * i ;
                if (a < 0) break;
                if (a == 0) return step + 1;
                if (!visited[num - i * i]) {
                    queue.add(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        throw new IllegalArgumentException("No Solution");
    }
}
