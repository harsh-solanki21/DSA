package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesIterative {

    // Subset / Subsequence
    // Power Set: Print all the possible subsequences of the String

    // Total no. of subsets will be 2^n
    // Time Complexity = O(n * 2^n)
    // Space complexity = O(n * 2^n)   i.e. 2^n is total subsets and n is space taken by each subset

    static List<List<Integer>> subsequence(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i : nums) {
            int len = ans.size();
            for (int j = 0; j < len; j++) {
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(i);
                ans.add(list);
            }
        }
        return ans;
    }


    // Time Complexity = O(n * 2^n)
    // Space complexity = O(n * 2^n)
    static ArrayList<String> allPossibleStrings(String s) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < (1 << s.length()); i++) {
            StringBuilder sub = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if ((i & (1 << j)) != 0) {
                    sub.append(s.charAt(j));
                }
            }
            if (!sub.isEmpty()) {
                ans.add(sub.toString());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsequence(nums));

        String str = "abc";
        System.out.println(allPossibleStrings(str));
    }

}
