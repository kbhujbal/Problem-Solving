// This code doesn't handle duplicates
// This code is for searching an element in a rotated sorted array

public class Search_element_in_rotated_sorted_array_1{
    public static void main(String[] args) {
        int [] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int x = 1;

        int low = 0, high = arr.length - 1;

        while (low <= high) { 
            int mid = (low + high)/2;

            if (arr[mid] == x) {
                System.out.println("Element found at index: " + mid);
                return;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else {
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        System.out.println("Element not found");
    }
}