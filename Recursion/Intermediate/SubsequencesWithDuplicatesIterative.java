package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequencesWithDuplicatesIterative {

    // Subsequences of a string with duplicate elements
    // Total no. of subsets we will have is 2^n
    // So, the Time Complexity = O(n * 2^n)
    // Space complexity = O(n * 2^n)   i.e. 2^n is total subsets and n is space taken by each subset
    static List<List<Integer>> subsetDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            end = ans.size() - 1;
            int n = ans.size();
            for (int j = start; j < n; j++) {
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(nums[i]);
                ans.add(list);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2};
        int[] nums = {5, 5, 5, 5, 5};
        System.out.println(subsetDuplicate(nums));
    }

}
