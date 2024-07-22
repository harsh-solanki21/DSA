package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subarrays {

    // Recursive Approach - O(n^2)
    static void subArraysRecursive(int[] nums, int start, int end) {
        if (end == nums.length)
            return;
        else if (start > end)
            subArraysRecursive(nums, 0, end + 1);
        else {
            for (int i = start; i <= end; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            subArraysRecursive(nums, start + 1, end);
        }
    }

    // Iterative Approach - O(n^3)
    static void subArrays(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
        }
    }

    // Iterative Approach - O(n^2)
    public static List<List<Integer>> findSubarrays(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                list.add(nums[j]);
                ans.add(new ArrayList<>(list));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        subArraysRecursive(nums, 0, 0);
        subArrays(nums);
        System.out.println(findSubarrays(nums));
    }

}
