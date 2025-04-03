public class MaximumTripletValue2 {
    public static void main(String[] args) {
        int[] nums = {12, 6, 1, 2, 7};
        long result = maximumTripletValue(nums);
        System.out.println("Output: " + result); 
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        
        long maxTriplet = 0;
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(nums[i], maxRight[i + 1]);
        }
        
        int maxLeft = nums[0];
        
        for (int j = 1; j < n - 1; j++) {
            long currentValue = (long)(maxLeft - nums[j]) * maxRight[j + 1];
            if (currentValue > maxTriplet) {
                maxTriplet = currentValue;
            }

            if (nums[j] > maxLeft) {
                maxLeft = nums[j];
            }
        }
        
        return maxTriplet;
    }
}