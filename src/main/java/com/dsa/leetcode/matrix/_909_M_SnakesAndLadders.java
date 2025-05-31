package com.dsa.leetcode.matrix;

import java.util.*;

public class _909_M_SnakesAndLadders {

    public static void main(String[] args) {

        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};

        System.out.println(new _909_M_SnakesAndLadders().snakesAndLadders(board));

    }


    public int snakesAndLadders(int[][] board) {

        int dimension = board.length;
        reverseOrderOfRows(board);//reversing row for our ease

        class BFS {
            int bfs() {
                Queue<Square> queue = new LinkedList<>();
                queue.add(new Square(1, 0));
                HashSet<Integer> visits = new HashSet<>();

                while (!queue.isEmpty()) {
                    Square currSquare = queue.poll();
                    int label = currSquare.label;
                    int moves = currSquare.moves;

                    for (int i = 1; i <= 6; i++) {
                        int nextSquare = label + i;
                        int[] cords = squareLabelsToCoordinates(nextSquare);
                        int row = cords[0];
                        int col = cords[1];
                        if (board[row][col] != -1) {//Checking for a Snake or a Ladder
                            nextSquare = board[cords[0]][cords[1]];//Executing Snake or Ladder
                        }
                        if (nextSquare == dimension * dimension) {
                            return moves + 1;//because we are playing 1 extra move
                        }
                        if (!visits.contains(nextSquare)) {
                            visits.add(nextSquare);
                            queue.add(new Square(nextSquare, moves + 1));

                        }

                    }
                }

                return -1;//No Such path to complete the game
            }

            int[] squareLabelsToCoordinates(int squareLabel) {

                int row = (squareLabel - 1) / dimension;//- 1 because the labels are starting from 1
                int col = (squareLabel - 1) % dimension;
                if (row % 2 != 0) {//Odd Rows
                    col = dimension - 1 - col;
                }
                return new int[]{row, col};
            }


        }
        return new BFS().bfs();


    }

    public void reverseOrderOfRows(int[][] board) {
        if (board == null || board.length <= 1) {
            // No need to reverse if null, empty, or only one row
            return;
        }

        int left = 0;
        int right = board.length - 1;

        while (left < right) {
            // Swap the 1D arrays (rows)
            int[] tempRow = board[left];
            board[left] = board[right];
            board[right] = tempRow;

            // Move pointers inwards
            left++;
            right--;
        }
    }


    public static int[][] reverseOrderOfRowsModern(int[][] board) {
        if (board == null || board.length <= 1) {
            return board; // No need to reverse
        }

        // 1. Convert the array of int[] to a List of int[]
        List<int[]> rowsAsList = Arrays.asList(board);

        // 2. Reverse the order of elements (int[] arrays) in the list
        Collections.reverse(rowsAsList);

        // 3. Convert the List back to a new int[][] array
        // Note: This creates a NEW 2D array. The original 'board' reference still points
        // to the old array, though its inner arrays (rows) are the same objects.
        // To modify the original 'board' in place with the reversed order,
        // you would copy the elements from the list back into the original array.
        return rowsAsList.toArray(new int[0][]);
    }

    static class Square {
        int label;
        int moves;

        public Square(int label, int moves) {
            this.label = label;
            this.moves = moves;
        }

        @Override
        public String toString() {
            return "Square{" +
                    "label=" + label +
                    ", moves=" + moves +
                    '}';
        }
    }
}
