package DP;

public class DistinctSubsequences {

    // Given two strings s and t, return the number of distinct subsequences of s which equals t.

    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)

    static int uniqueSubsequences(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[t.length()][s.length()];
    }


    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(uniqueSubsequences(s, t));
    }

}
