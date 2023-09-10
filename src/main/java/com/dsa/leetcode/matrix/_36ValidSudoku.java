package com.dsa.leetcode.matrix;

import java.util.HashMap;

public class _36ValidSudoku {
//    https://leetcode.com/problems/valid-sudoku/submissions/


    public static void main(String[] args) {
        char[][] sudoku = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        char[][] validSudoku =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println('5' - '1');
        System.out.println(isValidSudoku(validSudoku));

    }

    public static boolean isValidSudoku(char[][] board) {

//         Time O(n) =  n + n + n^3 = n^3 (row traversal + column traversal + sub-box traversal)
//       Space O(n) = 3n = n (3 boolean array of size 9)
//       =| n is dimension of the square matrix


        //check for each row
        for (int i = 0; i < board.length; i++) {//O(n^2) time
            boolean[] row = new boolean[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {

                    if (row[board[i][j] - '1']) {
                        //'1' is subtracted to get the index of the number in the row array as '1' - '1' = 0, '2' - '1' = 1, '3' - '1' = 2 and so on
                        return false;
                    }
                    row[board[i][j] - '1'] = true;
                }
            }
        }

        //check for each column
        for (int j = 0; j < board[0].length; j++) {//O(n^2) time
            boolean[] column = new boolean[9];
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {

                    if (column[board[i][j] - '1']) {
                        //'1' is subtracted to get the index of the number in the column array as '1' - '1' = 0, '2' - '1' = 1, '3' - '1' = 2 and so on
                        return false;
                    }
                    column[board[i][j] - '1'] = true;
                }
            }
        }

        //check for each 3*3 sub-box
//        for (int block = 0; block < 9; block++) {//O(n) time
//            boolean[] subBox = new boolean[9];
//            for (int i = (block / 3) * 3; i < ((block / 3) * 3) + 3; i++) {//O(n^2) time
//                for (int j = (block % 3) * 3; j < ((block % 3) * 3) + 3; j++) {
//                    if (board[i][j] != '.') {
//
//                        if (subBox[board[i][j] - '1']) {
//                            //'1' is subtracted to get the index of the number in the subBox array as '1' - '1' = 0, '2' - '1' = 1, '3' - '1' = 2 and so on
//                            return false;
//                        }
//                        subBox[board[i][j] - '1'] = true;
//                    }
//                }
//            }
//        }

        // to traverse the 3*3 sub-boxes in the sudoku kinda BFS
        for (int i = 0; i < board.length; i += 3) {//O(3 * 3) O(n)  time
            for (int j = 0; j < board[0].length; j += 3) {

                boolean[] subBox = new boolean[9];
                //i,j
                for (int k = i; k < i + 3; k++) {//O(n^2) time
                    for (int l = j; l < j + 3; l++) {
//                        if (board[i + k][j + l] != '.') {
//
//                            if (subBox[board[i + k][j + l] - '1']) {
//                                //'1' is subtracted to get the index of the number in the subBox array as '1' - '1' = 0, '2' - '1' = 1, '3' - '1' = 2 and so on
//                                return false;
//                            }
//                            subBox[board[i + k][j + l] - '1'] = true;


                        if (board[k][l] != '.') {

                            if (subBox[board[k][l] - '1']) {
                                //'1' is subtracted to get the index of the number in the subBox array as '1' - '1' = 0, '2' - '1' = 1, '3' - '1' = 2 and so on
                                return false;
                            }
                            subBox[board[k][l] - '1'] = true;
                        }

                    }
                }
            }
        }

        return true;//if all the above conditions are satisfied

    }

    /**
     * Checks if a given Sudoku board is valid.
     *
     * @param board A 9x9 array of characters representing the Sudoku board.
     * @return True if the Sudoku board is valid, False otherwise.
     */

    public static boolean isSudokuValidWRONG(char[][] board) {
        // Create a hash table to store the numbers in each block.
        HashMap<Integer, Integer>[] blocks = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            blocks[i] = new HashMap<>();
        }

        // Create a hash table to store the numbers in each row.
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
        }

        // Create a hash table to store the numbers in each column.
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            columns[i] = new HashMap<>();
        }

        // Iterate over the board.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Get the number at the current cell.
                char number = board[i][j];

                // If the number is not a dot, then add it to the hash tables for the block, row, and column.
                if (number != '.') {
                    int blockIndex = (i / 3) * 3 + j / 3;
                    blocks[blockIndex].put(number - '1', blocks[blockIndex].getOrDefault(number - '1', 0) + 1);
                    rows[i].put(number - '1', rows[i].getOrDefault(number - '1', 0) + 1);
                    columns[j].put(number - '1', columns[j].getOrDefault(number - '1', 0) + 1);
                }
            }
        }

        // Check if each block contains all unique numbers from 1 to 9.
        for (int i = 0; i < 9; i++) {
            // Comment: Check if the size of the hash table for the current block is equal to 9.
            if (blocks[i].size() != 9) {
                return false;
            }
        }

        // Check if each row contains all unique numbers from 1 to 9.
        for (int i = 0; i < 9; i++) {
            // Comment: Check if the size of the hash table for the current row is equal to 9.
            if (rows[i].size() != 9) {
                return false;
            }
        }

        // Check if each column contains all unique numbers from 1 to 9.
        for (int i = 0; i < 9; i++) {
            // Comment: Check if the size of the hash table for the current column is equal to 9.
            if (columns[i].size() != 9) {
                return false;
            }
        }

        // The Sudoku board is valid.
        return true;
    }
}
