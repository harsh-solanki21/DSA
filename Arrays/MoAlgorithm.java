package Arrays;

import java.util.Arrays;

public class MoAlgorithm {

    // Mo's Algorithm / Query Square Root Decomposition
    // TC - O(√n)
    // SC - O(n + √n)

    static int moAlgorithm(int[] nums) {
        int[] blocks = sqrtDecomposition(nums);
        System.out.println("Blocks: " + Arrays.toString(blocks));

        int sqrt = (int) Math.sqrt(nums.length);

        int queryResult = query(nums, blocks, 2, 7, sqrt);
        System.out.println("Sum of elements from index 2 to 7: " + queryResult);

        update(nums, blocks, 5, 10, sqrt);
        System.out.println("Updated blocks: " + Arrays.toString(blocks));
        System.out.println("Updated nums: " + Arrays.toString(nums));

        queryResult = query(nums, blocks, 2, 7, sqrt);
        System.out.println("Sum of elements from index 2 to 7 after update: " + queryResult);

        return queryResult;
    }

    private static int[] sqrtDecomposition(int[] nums) {
        int sqrt = (int) Math.sqrt(nums.length);
        int blockId = -1;
        int[] blocks = new int[sqrt + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i % sqrt == 0) {
                blockId++;
            }
            blocks[blockId] += nums[i];
        }

        return blocks;
    }

    private static int query(int[] nums, int[] blocks, int left, int right, int sqrt) {
        int ans = 0;

        // left
        while (left % sqrt != 0 && left <= right) {
            ans += nums[left];
            left++;
        }

        // middle
        while (left + sqrt <= right) {
            ans += blocks[left / sqrt];
            left += sqrt;
        }

        // right
        while (left <= right) {
            ans += nums[left];
            left++;
        }

        return ans;
    }

    private static void update(int[] nums, int[] blocks, int index, int val, int sqrt) {
        int blockId = index / sqrt;
        blocks[blockId] += (val - nums[index]);
        nums[index] = val;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        System.out.println(moAlgorithm(nums));
    }
}
