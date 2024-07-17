package Sorting;

import java.util.Arrays;

public class BubbleSort {

    // Repeatedly swap adjacent elements if they are in wrong order (largest element will be moved to the last index)

    // Time Complexity:
    // Best Case    - O(n)  // when the array is already sorted
    // Average Case - O(n^2)
    // Worst Case   - O(n^2)

    // Space Complexity: O(1)

    static void bubbleSort(int[] nums) {
        boolean swapped = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
