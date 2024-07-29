package Backtracking;

public class PlaceMaximumNonattackingKnights {

    // https://www.geeksforgeeks.org/maximum-non-attacking-knights-that-can-be-placed-on-an-nm-chessboard/

    // TC - O(2^(n * m))
    // SC - O(n * m)

    static int[][] moves = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    static int maxKnights(int n, int m) {
        return knights(n, m, new boolean[n][m], 0, 0, 0);
    }

    private static int knights(int n, int m, boolean[][] board, int row, int col, int count) {
        if (col == m) {
            row++;
            col = 0;
        }

        if (row == n) {
            return count;
        }

        // Try not placing a knight
        int without = knights(n, m, board, row, col + 1, count);

        // Try placing a knight if it's safe
        if (isSafe(board, row, col, n, m)) {
            board[row][col] = true;
            int with = knights(n, m, board, row, col + 1, count + 1);
            board[row][col] = false;
            return Math.max(with, without);
        }

        return without;
    }

    private static boolean isSafe(boolean[][] board, int row, int col, int n, int m) {
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 4, m = 5;
        System.out.println(maxKnights(n, m));
    }

}
