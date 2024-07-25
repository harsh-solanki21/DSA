import java.util.*;

public class Main {

// Example: array = [1,2,3,4]
// Subarray : [1,2],[1,2,3] - is continuous and maintains relative order of elements, Subarrays: n*(n+1)/2
// Subsequence: [1,2,4] - is not continuous but maintains relative order of elements, Subsequences: 2^n-1
// Subset: [1,3,2] - is not continuous and does not maintain relative order of elements, subsets: 2^n


    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solve(0, board, ans);
        return ans;
    }

    private static void solve(int row, boolean[][] board, List<List<String>> ans) {
        if (row == board.length) {
            display(board, ans);
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = true;
                solve(row + 1, board, ans);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(int row, int col, boolean[][] board) {
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return true;
            }
        }

        for (int i = row + 1, j = col + 1; i < board.length && j < board[0].length; i++, j++) {
            if (board[i][j]) {
                return true;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return true;
            }
        }

        return false;
    }

    private static void display(boolean[][] board, List<List<String>> ans) {
        for (int i = 0; i < board.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    list.add("Q");
                } else {
                    list.add(".");
                }
            }
            ans.add(list);
        }

        for (List<String> i : ans) {
            System.out.println(i);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }


}
