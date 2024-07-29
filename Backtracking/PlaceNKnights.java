package Backtracking;

import java.util.Arrays;

public class PlaceNKnights {

    // https://www.geeksforgeeks.org/place-k-knights-such-that-they-do-not-attack-each-other/

    // TC - O(2^(n * m))
    // SC - O(n * m)

    static int nKnights(int n, int m, int k) {
        char[][] board = new char[n][m];
        for (char[] i : board) {
            Arrays.fill(i, '.');
        }
        return placeKnights(n, m, k, board, 0, 0);
    }

    private static int placeKnights(int n, int m, int k, char[][] board, int row, int col) {
        if (k == 0) {
            displayBoard(board);
            return 1;
        }
        if (col == m) {
            row++;
            col = 0;
        }
        if (row == n) {
            return 0;
        }

        int count = 0;
        count += placeKnights(n, m, k, board, row, col + 1);  // don't place
        if (isSafe(board, row, col, n, m)) {
            board[row][col] = 'K';
            count += placeKnights(n, m, k - 1, board, row, col + 1);  // place
            board[row][col] = '.';
        }

        return count;
    }

    private static boolean isSafe(char[][] board, int row, int col, int n, int m) {
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && board[newRow][newCol] == 'K') {
                return false;
            }
        }
        return true;
    }

    private static void displayBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 4, m = 3, k = 6;
//        int n = 3, m = 3, k = 5;
        System.out.println("Total number of solutions: " + nKnights(n, m, k));
    }

}
