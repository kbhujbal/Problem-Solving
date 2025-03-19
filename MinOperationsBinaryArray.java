import java.util.Arrays;

public class MinOperationsBinaryArray {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i + 2 < n; ++i) {
            if (nums[i] == 0) {
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                operations++;
            }
        }

        if (nums[n - 1] == 0 || nums[n - 2] == 0) {
            return -1;
        }

        return operations;
    }

    public static void main(String[] args) {
        // Example test cases
        int[] nums1 = {0, 1, 0, 1, 0}; // Expected output: 2
        int[] nums2 = {1, 1, 0, 0, 1}; // Expected output: -1 (not possible)
        int[] nums3 = {0, 0, 0, 0, 1}; // Expected output: 2

        System.out.println("Test Case 1: " + Arrays.toString(nums1) + " -> " + minOperations(nums1));
        System.out.println("Test Case 2: " + Arrays.toString(nums2) + " -> " + minOperations(nums2));
        System.out.println("Test Case 3: " + Arrays.toString(nums3) + " -> " + minOperations(nums3));
    }
}
