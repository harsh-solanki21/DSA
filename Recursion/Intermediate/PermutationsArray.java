package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.List;

public class PermutationsArray {


    // Approach 1
    // Time Complexity: O(n * n!)
    // Space Complexity: O(n * n!)

    static List<List<Integer>> arrayPermutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permutate(nums, freq, ans, new ArrayList<>());
        return ans;
    }

    private static void permutate(int[] nums, boolean[] freq, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                list.add(nums[i]);
                permutate(nums, freq, ans, list);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }


    // Approach 2
    // Time Complexity: O(n * n!)
    // Space Complexity: O(n * n!)

    static List<List<Integer>> arrayPermutations2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0, ans);
        return ans;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, ans);
            swap(nums, i, index);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(arrayPermutations(nums));
        System.out.println(arrayPermutations2(nums));
    }

}
