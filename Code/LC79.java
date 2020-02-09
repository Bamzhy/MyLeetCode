package com.bamzhy.My_LeetCode.Code;

import java.util.List;

public class LC79 {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;
        if (m == 0)
            throw new IllegalArgumentException("board can not be empty!");
        n = board[0].length;
        if (n == 0)
            throw new IllegalArgumentException("board can not be empty");
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWorld(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWorld(char[][] board, String word, int index, int i, int j) {
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }

        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + d[k][0];
                int newY = j + d[k][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (searchWorld(board, word, index + 1, newX, newY))
                        System.out.println(board[newX][newY]);
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;

    }
}
