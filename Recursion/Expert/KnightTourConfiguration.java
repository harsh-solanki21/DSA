package Recursion.Expert;

public class KnightTourConfiguration {

    // https://leetcode.com/problems/check-knight-tour-configuration/description/

    // Approach 1
    // TC - O(8^(n^2))
    // Sc - O(n^2)
    static boolean checkValidGrid(int[][] grid) {
        return knightsTour(grid, 0, 0, 0);
    }

    private static boolean knightsTour(int[][] grid, int row, int col, int index) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != index) {
            return false;
        }
        if (index == grid.length * grid.length - 1) {
            return true;
        }
        int[][] moves = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (knightsTour(grid, newRow, newCol, index + 1)) {
                return true;
            }
        }
        return false;
    }


    // Approach 2
    // TC - O(n^2)
    // Sc - O(n^2)
    static boolean checkValidGrid2(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        int n = grid.length;
        int[][] positions = new int[n * n][2];

        // Step 1: Store the positions of each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positions[grid[i][j]] = new int[]{i, j};
            }
        }

        // Step 2: Verify the moves
        for (int i = 1; i < n * n; i++) {
            int[] prev = positions[i - 1];
            int[] curr = positions[i];

            int rowDiff = Math.abs(prev[0] - curr[0]);
            int colDiff = Math.abs(prev[1] - curr[1]);

            // Check if it's a valid knight's move
            if (!((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}};
        System.out.println(checkValidGrid(grid));
        System.out.println(checkValidGrid2(grid));
    }

}
