// Array contains unique numbers 

// This problem uses the logic of finding the minimum element in a rotated sorted array.
// Index of the minimum element is the number of rotations.

public class Count_Sorted_Array_Rotations {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        
        int low = 0, high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = (low + high)/2;

            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            else{
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        System.out.println("Array is rotated " + index + " times");
    }
}

