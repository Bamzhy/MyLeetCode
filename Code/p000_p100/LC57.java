package com.bamzhy.My_LeetCode.Code.p000_p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
public class LC57 {
    List<List<String>> res;
    boolean[] col, dia1, dia2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        if (n <= 0) return res;

        List<Integer> list = new ArrayList<>();
        putQueen(n, 0, list);
        return res;
    }

    // try to put the index row 's queen
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index+i] && !dia2[index-i+n-1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(Integer.valueOf(i));
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[row.get(i)] = 'Q';
            board.add(new String(chars));
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new LC57().solveNQueens(8);
        for (List<String> a:lists) {
            System.out.println(a.toString());
        }
    }
}
