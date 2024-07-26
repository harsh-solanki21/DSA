package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    // https://leetcode.com/problems/n-queens/description/

    // Time complexity: O(N! * N)
    // For the first row, we have N choices.
    // For the second row, we have at most N-1 choices.
    // For the third row, we have at most N-2 choices, and so on.
    // This leads to N * (N-1) * (N-2) * ... * 1 = N! possibilities in the worst case.
    // The isSafe() function takes O(N) time in the worst case, as it may need to check up to N-1 squares in a column or diagonal.
    // Therefore, the overall time complexity is O(N! * N) = O(N!), as N! dominates N for large values of N.

    // Space complexity: O(N! * N)
    // The board: O(N^2) for the N x N char array.
    // The recursion stack: O(N) in the worst case, as the maximum depth of recursion is N.
    // The ans list: O(N! * N) in the worst case, as there could be up to N! solutions, each requiring N strings of length N.
    // The dominant factor here is the ans list, so the overall space complexity is O(N! * N).

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        queens(board, ans, 0);
        return ans;
    }

    private static void queens(char[][] board, List<List<String>> ans, int row) {
        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                queens(board, ans, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            list.add(row);
        }
        return list;
    }


    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = solveNQueens(n);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.println(ans.get(i).get(j));
            }
            System.out.println();
        }

        System.out.println("Total solutions: " + ans.size());
    }

}
