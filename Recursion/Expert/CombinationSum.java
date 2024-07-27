package Recursion.Expert;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // https://leetcode.com/problems/combination-sum/description/

    // The Time Complexity of generating all subsets is O(2^n).
    // Each subset generation and checking if it sums up to the target takes O(n) time in the worst case.
    // Therefore, the overall time complexity of the given code is O(2^n * n).


    // Unique Combination Sum
    static List<List<Integer>> uniqueCombinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        uniqueCombinations(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private static void uniqueCombinations(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }

        if (candidates[index] <= target) {
            list.add(candidates[index]);
            uniqueCombinations(candidates, target - candidates[index], index, ans, list);
            list.remove(list.size() - 1);
        }
        uniqueCombinations(candidates, target, index + 1, ans, list);
    }


    // Not Unique Combinations
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinations(candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void combinations(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinations(candidates, target - candidates[i], ans, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(uniqueCombinationSum(candidates, target));
        System.out.println(combinationSum(candidates, target));
    }

}
