public class Next_permutation {
    public void nextPermutation(int[] nums) {
        // Find first number from last which is smaller than the number on right
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // find first number from last which is greater than number at index i
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Next_permutation solution = new Next_permutation();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

// Logic of this code:
// First find the number from last which is smaller than the element on it's right (call it's index i)
// Then find the first number from last which greater than the number at index i (call it's index j)
// swap numbers at index i and j (i.e. swap(i, j))
// reverse the subarray starting from (i + 1) till the last element of the main array
// final answer is the array in the above step