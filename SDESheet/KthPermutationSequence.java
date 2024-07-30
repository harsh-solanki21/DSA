package SDESheet;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {

    // https://leetcode.com/problems/permutation-sequence/description/

    // TC - O(n)
    // SC - O(n)

    static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);

        StringBuilder ans = new StringBuilder();
        k--;
        while (true) {
            ans.append(nums.get(k / fact));
            nums.remove(k / fact);
            if (nums.isEmpty()) {
                break;
            }
            k %= fact;
            fact /= nums.size();
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(getPermutation(n, k));
    }

}
