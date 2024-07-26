import java.util.*;

public class Main {

// Example: array = [1,2,3,4]
// Subarray : [1,2],[1,2,3] - is continuous and maintains relative order of elements, Subarrays: n*(n+1)/2
// Subsequence: [1,2,4] - is not continuous but maintains relative order of elements, Subsequences: 2^n-1
// Subset: [1,3,2] - is not continuous and does not maintain relative order of elements, subsets: 2^n


    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int index) {
        if (target < 0 || index >= candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(list);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], ans, list, index + 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

}
