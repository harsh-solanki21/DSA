package DP.TwoDimensional;

public class MinimumSumPath {

    // Given a 2D grid (N x M) with numbers written in each cell, find the path from top left (0, 0) to bottom right (n-1, m-1) with
    // minimum sum of values on the path.

    // Recursive
    // TC - O(2^(m + n))
    // SC - O(m + n)
    static int minSum(int[][] nums, int row, int col) {
        if (row >= nums.length || col >= nums[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == nums.length - 1 && col == nums[0].length - 1) {
            return nums[row][col];
        }

        int right = minSum(nums, row, col + 1);
        int down = minSum(nums, row + 1, col);
        return nums[row][col] + Math.min(right, down);
    }


    // Memoization
    // TC - O(m * n)
    // SC - O(m * n)
    static int minSumMemoize(int[][] nums, int row, int col, int[][] dp) {
        if (row >= nums.length || col >= nums[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == nums.length - 1 && col == nums[0].length - 1) {
            return nums[row][col];
        }
        if (dp[row][col] > 0) {
            return dp[row][col];
        }

        int right = minSumMemoize(nums, row, col + 1, dp);
        int down = minSumMemoize(nums, row + 1, col, dp);
        dp[row][col] = nums[row][col] + Math.min(right, down);
        return dp[row][col];
    }


    // Tabulation
    // TC - O(m * n)
    // SC - O(m * n)
    public static int minSumTabulation(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = nums[m - 1][n - 1];

        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = dp[m - 1][j + 1] + nums[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] + nums[i][n - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = nums[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }


    // Space Optimization
    // TC - O(m * n)
    // SC - O(n)
    public static int minSumTabulationOptimized(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[] dp = new int[n];

        dp[n - 1] = nums[m - 1][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = dp[j + 1] + nums[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] += nums[i][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = nums[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        int[][] nums = {
                {1, 5, 8},
                {6, 2, 7},
                {9, 3, 4}
        };

        System.out.println(minSum(nums, 0, 0));
        System.out.println(minSumMemoize(nums, 0, 0, new int[nums.length][nums[0].length]));
        System.out.println(minSumTabulation(nums));
        System.out.println(minSumTabulationOptimized(nums));
    }

}
