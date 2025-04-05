public class SubsetXORSum {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }

        int withCurrent = dfs(nums, index + 1, currentXor ^ nums[index]);
        int withoutCurrent = dfs(nums, index + 1, currentXor);
        return withCurrent + withoutCurrent;
    }

    public static void main(String[] args) {
        SubsetXORSum solution = new SubsetXORSum();

        int[] nums = {5, 1, 6};
        int result = solution.subsetXORSum(nums);

        System.out.println("Output: " + result);
    }
}
