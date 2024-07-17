package Sorting;

import java.util.Arrays;

public class SelectionSort {

    // Find the minimum element in array and swap it with element at the beginning

    // Time Complexity:
    // Best Case    - O(n^2)
    // Average Case - O(n^2)
    // Worst Case   - O(n^2)

    // Space Complexity: O(1)

    static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
