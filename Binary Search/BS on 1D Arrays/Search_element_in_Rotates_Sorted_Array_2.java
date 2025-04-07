public class Search_element_in_Rotates_Sorted_Array_2{
    public static void main(String[] args) {
        int [] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int x = 10;

        int low = 0, high = arr.length - 1;
        boolean found = false;

        while (low <= high) { 
            int mid = (low + high)/2;

            if(arr[mid] == x){
                found = true;
            }

            // Check if duplicates are present
            // If duplicates are present, we can skip them by moving the low and high pointers 
            // towards the center of the array
            // This is done to avoid infinite loop when all elements are same
            // and we are not able to find the element in the array   
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if(arr[low] <= arr[mid]){
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        System.out.println(found ? "Element found" : "Element not found");
    }
}