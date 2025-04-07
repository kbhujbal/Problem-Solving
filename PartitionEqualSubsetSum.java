public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        // If the total sum is odd, we can't partition it into equal subsets
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // We can always make 0 sum with empty subset

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        // Sample test case
        int[] nums1 = {1, 5, 11, 5};  // Expected: true
        int[] nums2 = {1, 2, 3, 5};   // Expected: false

        System.out.println("Can partition [1, 5, 11, 5]? " + canPartition(nums1));
        System.out.println("Can partition [1, 2, 3, 5]? " + canPartition(nums2));
    }
}
