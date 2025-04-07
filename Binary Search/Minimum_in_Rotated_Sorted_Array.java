public class Minimum_in_Rotated_Sorted_Array{
    public static void main(String [] args){
        int [] arr = {4, 5, 6, 7, 0, 1, 2, 3};

        int low = 0, high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) { 
            int mid = (low + high)/2;

            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            }
            else{
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        System.out.println("Minimum element in the rotated sorted array is: " + min);
    }
}