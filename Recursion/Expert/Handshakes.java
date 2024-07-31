package Recursion.Expert;

public class Handshakes {


//    You are given an even number of people n that stand around a circle and each person shakes hands with someone else,
//    so that there are n / 2 handshakes total.

//    Return the number of ways these handshakes could occur such that none of the handshakes cross.
//    Since this number could be very big, return the answer mod 10^9 + 7

    static int count(int n) {
        if (n == 0) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans += count(i) * count(n - 2 - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(count(n));
    }

}
