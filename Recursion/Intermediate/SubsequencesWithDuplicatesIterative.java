package Recursion.Intermediate;

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

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());  // empty set

        int cachedSize = 0, startIdx = 0;
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> newResult = new ArrayList<>();  // used for new lists
            // set startIdx first before we update cachedSize
            startIdx = (i > 0 && nums[i - 1] == nums[i]) ? cachedSize : 0; // if duplicate occurs
            cachedSize = result.size(); // cache the size for startIdx in the next round
            for (int j = startIdx; j < result.size(); ++j) {
                List<Integer> L = result.get(j);
                L = new ArrayList<>(L);  // copy
                L.add(nums[i]);
                newResult.add(L);
            }
            result.addAll(newResult);  // concatenate
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 3};
        int[] nums = {5, 5, 5, 5, 5};
        System.out.println(subsetsWithDup(nums));
    }

}
