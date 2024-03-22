package com.dsa.leetcode.backtracking;

import java.util.HashSet;

public class _79WordSearch {

    public static void main(String[] args) {

        char grid[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = "ABCCED";

        char grid2[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word2 = "ABCESEEEFS";

        boolean exist = exist(grid2, word2);
        System.out.println(exist);


    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int column = board[board.length - 1].length;
        HashSet<String> set = new HashSet<>();

//        O(n) r *c * dfs^4 = r *c * word^4
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (dfs(board, word, set, i, j, 0))
                    return true;
                set.clear();
            }

        }

        return false;


    }

    static boolean dfs(char[][] board, String word, HashSet<String> set, int i, int j, int m) {
        int rows = board.length;
        int column = board[board.length - 1].length;

        if (m == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 ||
                i >= rows || j >= column ||
                word.charAt(m) != board[i][j] || set.contains(i + "_" + j)) {
            return false;
        }

        //if we found the element
        set.add(i + "_" + j);
        m += 1;
        boolean result = dfs(board, word, set, i + 1, j, m) ||
                dfs(board, word, set, i - 1, j, m) ||
                dfs(board, word, set, i, j + 1, m) ||
                dfs(board, word, set, i, j - 1, m);


        set.remove(i + "_" + j);//clean up is ver important to resume the operation
        return result;

    }

   public static class Solution {

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean found = dfs(board, word, i, j, 0);

                        if (found) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        public boolean dfs(char[][] board, String word, int i, int j, int index) {//without using set
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
                return false;
            }

            if (index == word.length() - 1) {
                return true;
            }

            char temp = board[i][j];
            board[i][j] = '*';

            boolean found = dfs(board, word, i + 1, j, index + 1) ||
                    dfs(board, word, i - 1, j, index + 1) ||
                    dfs(board, word, i, j + 1, index + 1) ||
                    dfs(board, word, i, j - 1, index + 1);

            board[i][j] = temp;
            return found;
        }
    }
}

