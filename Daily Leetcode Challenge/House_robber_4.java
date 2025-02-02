// Leetcode 2560

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
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }

    private boolean canRobK(int[] nums, int k, int maxValue) {
        int count = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] <= maxValue) {
                count++;
                i++;
            }
            i++; 
        }
        return count >= k;
    }

    public static void main(String[] args) {
        House_robber_4 robber = new House_robber_4();
        
        int[] nums = {2, 3, 5, 9}; 
        int k = 2;
        
        int result = robber.minCapability(nums, k);
        
        System.out.println("Minimum Maximum Capability: " + result); 
    }
}
