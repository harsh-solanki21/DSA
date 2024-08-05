package Recursion.Basic;

public class NearbySquares {

    // You are given an array A of length N. There are two empty arrays, B and C.
    // You have to put every element of A into either B or C.
    // The score of an array is defined as the square of the sum of all of its elements.
    // Find the minimum possible absolute difference between the score of B and C.

    // TC - O(2^n)
    // SC - O(n)

    static int nearbySquares(int[] nums) {
        return diff(nums, 0, 0, 0);
    }

    private static int diff(int[] nums, int index, int arr1, int arr2) {
        if (index == nums.length) {
            return Math.abs(arr1 * arr1 - arr2 * arr2);
        }

        int first = diff(nums, index + 1, arr1 + nums[index], arr2);
        int second = diff(nums, index + 1, arr1, arr2 + nums[index]);
        return Math.min(first, second);
    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 10, 3};  // 44
//        int[] nums = {1, 3, 5, 4, 5};  // 0
        System.out.println(nearbySquares(nums));
    }

}
