package Recursion.Expert;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {

    // Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.

    // TC - O(2^n)
    // SC - O(2^n), due to storage of all subset sums

    static ArrayList<Integer> subsetSums(ArrayList<Integer> nums) {
        if (nums.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        subset(nums, ans, 0, 0);
        return ans;
    }

    private static void subset(ArrayList<Integer> nums, ArrayList<Integer> ans, int index, int sum) {
        if (index == nums.size()) {
            ans.add(sum);
            return;
        }
        subset(nums, ans, index + 1, sum);
        subset(nums, ans, index + 1, sum + nums.get(index));
    }


    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 1));
        System.out.println(subsetSums(nums));
    }

}
