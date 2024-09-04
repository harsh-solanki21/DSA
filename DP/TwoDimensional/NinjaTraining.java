package DP.TwoDimensional;

import java.util.Arrays;

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
    // TC - O(M^N), M is the number of columns (points[0].length), N is the number of rows (points.length)
    // SC - O(N)
    static int ninjaTraining(int[][] points) {
        return trainingRecursive(points, 0, 3);
    }

    private static int trainingRecursive(int[][] points, int row, int prev) {
        if (row == points.length) {
            return 0;
        }

        int maxPoints = 0;
        for (int j = 0; j < points[0].length; j++) {
            if (row != prev) {
                int count = points[row][j] + trainingRecursive(points, row + 1, j);
                maxPoints = Math.max(maxPoints, count);
            }
        }

        return maxPoints;
    }


    // Memoization
    // TC - O(M * N)
    // SC - O(N)
    static int ninjaTrainingMemoize(int[][] points) {
        return trainingMemoize(points, 0, points[0].length, new int[points.length][4]);
    }

    private static int trainingMemoize(int[][] points, int row, int prev, int[][] dp) {
        if (row == points.length) {
            return 0;
        }
        if (dp[row][prev] > 0) {
            return dp[row][prev];
        }

        int maxPoints = 0;
        for (int j = 0; j < points[0].length; j++) {
            if (row != prev) {
                int count = points[row][j] + trainingMemoize(points, row + 1, j, dp);
                maxPoints = Math.max(maxPoints, count);
            }
        }

        dp[row][prev] = maxPoints;
        return maxPoints;
    }


    // Tabulation
    // TC - O(N * 4 * 3) = O(N)
    // SC - O(N * 4) = O(N)
    static int ninjaTrainingTabulation(int[][] points) {
        int[][] dp = new int[points.length][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < points.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[points.length - 1][3];
    }


    // Space Optimization
    // TC - O(N)
    // SC - O(1)
    static int ninjaTrainingSpaceOptimize(int[][] points) {
        int prev0 = Math.max(points[0][1], points[0][2]);
        int prev1 = Math.max(points[0][0], points[0][2]);
        int prev2 = Math.max(points[0][0], points[0][1]);
        int prev3 = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < points.length; day++) {
            int curr0 = Math.max(points[day][1] + prev1, points[day][2] + prev2);
            int curr1 = Math.max(points[day][0] + prev0, points[day][2] + prev2);
            int curr2 = Math.max(points[day][0] + prev0, points[day][1] + prev1);
            int curr3 = Math.max(curr0, Math.max(curr1, curr2));

            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
            prev3 = curr3;
        }

        return prev3;
    }


    public static void main(String[] args) {
        int[][] points = {
                {18, 11, 19},
                {4, 13, 7},
                {1, 8, 13}
        };

        System.out.println(ninjaTraining(points));
        System.out.println(ninjaTrainingMemoize(points));
        System.out.println(ninjaTrainingTabulation(points));
        System.out.println(ninjaTrainingSpaceOptimize(points));
    }

}
