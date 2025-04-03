public class MaximumTripletValue1 {
    public static void main(String[] args) {
        int[] nums = {12, 6, 1, 2, 7};
        long result = maximumTripletValue(nums);
        System.out.println("Output: " + result); // Expected output: 77
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTriplet = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long currentValue = (long) (nums[i] - nums[j]) * nums[k];
                    if (currentValue > maxTriplet) {
                        maxTriplet = currentValue;
                    }
                }
            }
        }

        return maxTriplet;
    }
}