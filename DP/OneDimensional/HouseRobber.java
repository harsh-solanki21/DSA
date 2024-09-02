package DP.OneDimensional;

public class HouseRobber {

    // https://leetcode.com/problems/house-robber/description/

    // Recursive
    // TC - O(2^n), SC - O(n)
    private static int rob(int[] nums, int index) {
        if (index == 0) {
            return nums[0];
        }
        if (index < 0) {
            return 0;
        }

        int pick = nums[index] + rob(nums, index - 2);
        int notPick = rob(nums, index - 1);
        return Math.max(pick, notPick);
    }


    // Memoization
    // TC - O(n), SC - O(n) + O(n)
    private static int robMemoize(int[] nums, int index, int[] dp) {
        if (index == 0) {
            return nums[0];
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] > 0) {
            return dp[index];
        }

        int pick = nums[index] + robMemoize(nums, index - 2, dp);
        int notPick = robMemoize(nums, index - 1, dp);

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }


    // Tabulation
    // TC - O(n), SC - O(n)
    private static int robTabulation(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[nums.length - 1];
    }


    // Space Optimization
    // TC - O(n), SC - O(1)
    private static int robSpaceOptimize(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;

            int ans = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(rob(nums, nums.length - 1));
        System.out.println(robMemoize(nums, nums.length - 1, new int[nums.length]));
        System.out.println(robTabulation(nums));
        System.out.println(robSpaceOptimize(nums));
    }

}
