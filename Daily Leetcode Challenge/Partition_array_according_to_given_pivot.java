import java.util.Arrays;

public class Partition_array_according_to_given_pivot {

    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0; 
        int right = n - 1; 
        int equalCount = 0; 

        for (int num : nums) {
            if (num == pivot) {
                equalCount++;
            }
        }

        for (int num : nums) {
            if (num < pivot) {
                result[left++] = num;
            } else if (num > pivot) {
                result[right--] = num;
            }
        }

        while (equalCount > 0) {
            result[left++] = pivot;
            equalCount--;
        }

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
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Pivot: " + pivot);

        int[] result = pivotArray(nums, pivot);

        System.out.println("Partitioned Array: " + Arrays.toString(result));
    }
}