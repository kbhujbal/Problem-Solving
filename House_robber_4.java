
public class House_robber_4 {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canRobK(nums, k, mid)) {
                right = mid; // Try for a smaller max value
            } else {
                left = mid + 1; // Increase the limit
            }
        }
        return left;
    }

    private boolean canRobK(int[] nums, int k, int maxValue) {
        int count = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] <= maxValue) {
                count++;
                i++; // Skip the next house (adjacency condition)
            }
            i++; // Move to the next house
        }
        return count >= k;
    }

    // Main method to test the function
    public static void main(String[] args) {
        House_robber_4 robber = new House_robber_4();
        
        // Example test case
        int[] nums = {2, 3, 5, 9}; 
        int k = 2;
        
        int result = robber.minCapability(nums, k);
        
        System.out.println("Minimum Maximum Capability: " + result); 
        // Expected Output: 3
    }
}
