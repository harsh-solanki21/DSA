package Recursion.Expert;

public class JosephusProblem {

    // Game of Execution / Josephus Problem
    // https://leetcode.com/problems/find-the-winner-of-the-circular-game/

    static int josephusProblem(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephusProblem(n - 1, k) + k - 1) % n + 1;
    }


    public static void main(String[] args) {
        int n = 7, k = 4;
        System.out.println(josephusProblem(n, k));
    }

}
