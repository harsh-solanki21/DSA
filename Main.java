import java.util.*;

public class Main {

// A subarray is a contiguous part of array and maintains relative ordering of elements.
// For an array/string of size n, there are n*(n+1)/2 non-empty subarrays/substrings.

// A subsequence maintain relative ordering of elements but may or may not be a contiguous part of an array.
// For a sequence of size n, we can have 2^n-1 non-empty sub-sequences in total.

// A subset MAY NOT maintain relative ordering of elements and can or cannot be a contiguous part of an array.
// For a set of size n, we can have (2^n) sub-sets in total.

// Example:
// array = [1,2,3,4]

// Subarray : [1,2],[1,2,3] - is continuous and maintains relative order of elements

// Subsequence: [1,2,4] - is not continuous but maintains relative order of elements

// Subset: [1,3,2] - is not continuous and does not maintain relative order of elements

// Some interesting observations:
// Every Subarray is a Subsequence.
// Every Subsequence is a Subset.


    static ArrayList<String> subsequence(String str) {
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
        for (int i = 0; i < ans.size(); i++) {

        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(subsequence(str));
    }

}
