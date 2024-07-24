package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    // https://leetcode.com/problems/combination-sum-ii/description/

    // TC - O(2^n)
    // SC - O(2^n * k), where k is recursion stack size


    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination2(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private static void combination2(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            combination2(candidates, target - candidates[i], i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

}
