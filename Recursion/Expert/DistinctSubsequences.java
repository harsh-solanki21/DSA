package Recursion.Expert;

import java.util.HashSet;

public class DistinctSubsequences {

    // TC - O(2^n)
    // SC - O(n)

    static HashSet<String> uniqueSubsequence(String s) {
        HashSet<String> ans = new HashSet<>();
        subsequences(s, 0, "", ans);
        return ans;
    }

    private static void subsequences(String s, int index, String current, HashSet<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }

        subsequences(s, index + 1, current + s.charAt(index), result);
        subsequences(s, index + 1, current, result);
    }

    public static void main(String[] args) {
        String str = "abcc";
        System.out.println(uniqueSubsequence(str));
    }

}
