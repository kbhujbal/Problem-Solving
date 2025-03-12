
class Maximum_count_positive_and_negative_int {
    public int maximumCount(int[] nums) {
        int negCount = findFirstPositiveIndex(nums);
        int posCount = nums.length - findFirstNonPositiveIndex(nums);
        return Math.max(negCount, posCount);
    }

    private int findFirstPositiveIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int findFirstNonPositiveIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Maximum_count_positive_and_negative_int solution = new Maximum_count_positive_and_negative_int();
        
        int[] nums = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        int result = solution.maximumCount(nums);
        
        System.out.println("Maximum count of either positive or negative integers: " + result);
    }
}
