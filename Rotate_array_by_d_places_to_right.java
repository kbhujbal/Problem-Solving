public class Rotate_array_by_d_places_to_right {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;

        int n = nums.length;
        d = d % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);

        System.out.println("Rotated array by d places to right: ");
        for(int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}