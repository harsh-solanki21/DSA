package DP;

public class HouseRobber2 {

    // https://leetcode.com/problems/house-robber-ii/description/

    // TC - O(n), SC - O(n) + O(n)
    private static int houseRobber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] first = new int[nums.length - 1];
        int[] second = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                first[i] = nums[i];
            }
            if (i > 0) {
                second[i - 1] = nums[i];
            }
        }

        return Math.max(rob(first), rob(second));
    }

    private static int rob(int[] nums) {
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
        int[] nums = {1, 2, 3, 1};
        System.out.println(houseRobber(nums));
    }

}
