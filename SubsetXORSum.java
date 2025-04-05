public class SubsetXORSum {

    // Solution method using DFS
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        // Include the current element
        int withCurrent = dfs(nums, index + 1, currentXor ^ nums[index]);
        // Exclude the current element
        int withoutCurrent = dfs(nums, index + 1, currentXor);
        return withCurrent + withoutCurrent;
    }

    // Main method to run test cases
    public static void main(String[] args) {
        SubsetXORSum solution = new SubsetXORSum();

        int[] nums = {5, 1, 6};
        int result = solution.subsetXORSum(nums);

        System.out.println("Output: " + result); // Expected output: 28
    }
}
