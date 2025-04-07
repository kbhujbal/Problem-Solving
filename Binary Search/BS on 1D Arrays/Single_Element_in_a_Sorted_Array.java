// Approach:
// 1. Use binary search to narrow down the location of the single element.
// 2. At each step, calculate the middle index `mid`.
// 3. Ensure `mid` is even for consistent pairing checks (adjust if it's odd).
// 4. If the element at `mid` is equal to the element at `mid + 1`, the single element must be on the right half.
//    -> Move `low` to `mid + 2` to skip the confirmed pair.
// 5. If the element at `mid` is not equal to the element at `mid + 1`, the single element lies on the left half.
//    -> Move `high` to `mid`.
// 6. Repeat until `low == high`, which will be the index of the single element.

public class Single_Element_in_a_Sorted_Array{
    public static void main(String [] args){
        int [] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        boolean found = false;
        int low = 1, high = arr.length - 2;

        if (arr.length == 1) {
            System.out.println("Single element is : " + arr[0]);
            return;
        }
        if (arr[0] != arr[1]) {
            System.out.println("Single element is : " + arr[0]);
            return;
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println("Single element is : " + arr[arr.length - 1]);
            return;
        }

        while (low <= high) { 
            int mid = (low + high)/2;
            
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid  + 1]) {
                System.out.println("Single element is : " + arr[mid]);
                found = true;
                break;
            }

            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if (!found) {
            System.out.println("There is no single element in the array");
        }
    }
}