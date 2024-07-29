package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // https://leetcode.com/problems/palindrome-partitioning/description/

    // Time complexity: O(n * 2^n)
    // Space complexity: O(n * 2^n)

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        substrings(s, 0, ans, new ArrayList<>());
        return ans;
    }

    private static void substrings(String s, int index, List<List<String>> ans, List<String> path) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                substrings(s, i + 1, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "aabbc";
        System.out.println(partition(s));
    }

}
