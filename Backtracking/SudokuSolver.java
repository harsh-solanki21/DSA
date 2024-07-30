package Backtracking;

public class SudokuSolver {

    // https://leetcode.com/problems/sudoku-solver/description/

    // TC - O(9^n^2)
    // SC - O(n^2)

    static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private static boolean solve(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        for (char i = '1'; i <= '9'; i++) {
            if (isValidPlacement(board, row, col, i)) {
                board[row][col] = i;
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isValidPlacement(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            // Check row
            if (board[i][col] == num) {
                return false;
            }

            // Check column
            if (board[row][i] == num) {
                return false;
            }

            // Check 3x3 subgrid
            int subgridRow = 3 * (row / 3) + i / 3; // Calculate row index of subgrid
            int subgridCol = 3 * (col / 3) + i % 3; // Calculate column index of subgrid

            if (board[subgridRow][subgridCol] == num) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }

}
