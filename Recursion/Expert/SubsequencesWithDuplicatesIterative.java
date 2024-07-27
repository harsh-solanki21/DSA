package Recursion.Expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequencesWithDuplicatesIterative {

    // https://leetcode.com/problems/subsets-ii/description/

    // Subsequences of a string with duplicate elements
    // Total no. of subsets we will have is 2^n
    // Time Complexity = O(n * 2^n)
    // Space complexity = O(n * 2^n)   i.e. 2^n is total subsets and n is space taken by each subset
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        int size = 0, start = 0;
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> result = new ArrayList<>();
            if (i > 0 && nums[i - 1] == nums[i]) {
                start = size;
            } else {
                start = 0;
            }
            size = ans.size();

            for (int j = start; j < ans.size(); j++) {
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(nums[i]);
                result.add(list);
            }

            ans.addAll(result);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 3};
        int[] nums = {5, 5, 5, 5, 5};
        System.out.println(subsetsWithDup(nums));
    }

}
