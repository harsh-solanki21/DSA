package DP;

public class NinjaTraining {

    // Ninja's Training

    // Ninja is planing N days-long training schedule.
    // Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves).
    // Each activity has some merit points on each day.
    // As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days.
    // Can you help Ninja find out the maximum merit points Ninja can earn?

    // You are given a 2D array of size N*3 POINTS with the points corresponding to each day and activity.
    // Your task is to calculate the maximum number of merit points that Ninja can earn.

    // For Example:
    // If the given POINTS array is [[1, 2, 5], [3, 1, 1] ,[3, 3, 3]], the answer will be 11 as 5 + 3 + 3.

    // Greedy approach will fail here.

    // Recursion
    // TC - O(3^N)
    // SC - O(N)
    static int ninjaTraining(int[][] points) {
        return training(points, points.length - 1, points[0].length);
    }

    private static int training(int[][] points, int row, int col) {
        if (row == points.length) {
            return 0;
        }

        int max = 0;
        for (int j = 0; j < points[0].length; j++) {
            if (j != col) {
                int count = points[row][j] + training(points, row + 1, j);
                max = Math.max(max, count);
            }
        }
        return max;
    }


    // Memoization
    // TC - O()
    // SC - O()
    static int ninjaTrainingMemoize(int[][] points) {
        return trainingMemoize(points, 0, 3, new int[points.length][4]);
    }

    private static int trainingMemoize(int[][] points, int row, int col, int[][] dp) {
        if (row == points.length) {
            return 0;
        }
        if (dp[row][col] > 0) {
            return dp[row][col];
        }

        int max = 0;
        for (int j = 0; j < points[0].length; j++) {
            if (j != col) {
                int count = points[row][j] + trainingMemoize(points, row + 1, j, dp);
                max = Math.max(max, count);
            }
        }
        dp[row][col] = max;
        return max;
    }


    public static void main(String[] args) {
        int[][] points = {
                {18, 11, 19},
                {4, 13, 7},
                {1, 8, 13}
        };

        System.out.println(ninjaTraining(points));
        System.out.println(ninjaTrainingMemoize(points));
    }

}
