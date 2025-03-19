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
        int[][] testCases = {
            {0, 1, 0, 1, 0},        // Expected output: 2
            {1, 1, 0, 0, 1},        // Expected output: -1 (not possible)
            {0, 0, 0, 0, 1},        // Expected output: 2
            {0, 1, 1, 1, 0, 0},     // Expected output: -1 (not possible)
            {0, 1, 1, 1}            // Expected output: 1
        };

        System.out.println("Running test cases...\n");
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = Arrays.copyOf(testCases[i], testCases[i].length);
            int result = minOperations(testCase);
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(testCases[i]) + " -> " + result);
        }
    }
}
