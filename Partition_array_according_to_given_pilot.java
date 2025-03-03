import java.util.Arrays;

public class Partition_array_according_to_given_pilot {

    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0; // Pointer for elements less than pivot
        int right = n - 1; // Pointer for elements greater than pivot
        int equalCount = 0; // Count of elements equal to pivot

        // First pass: Count elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                equalCount++;
            }
        }

        // Second pass: Place elements less than pivot at the beginning
        // and elements greater than pivot at the end
        for (int num : nums) {
            if (num < pivot) {
                result[left++] = num;
            } else if (num > pivot) {
                result[right--] = num;
            }
        }

        // Fill the middle with elements equal to pivot
        while (equalCount > 0) {
            result[left++] = pivot;
            equalCount--;
        }

        // Reverse the elements greater than pivot to maintain their relative order
        reverse(result, left, n - 1);

        return result;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Pivot: " + pivot);

        int[] result = pivotArray(nums, pivot);

        System.out.println("Partitioned Array: " + Arrays.toString(result));
    }
}