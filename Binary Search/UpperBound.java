// Upper Bound
// The upper bound of a value x is the first position where x can be inserted after all occurrences of x in the array.

// In other words:

// It returns the index of the first element greater than x.

// If x exists multiple times, it gives the next index after the last occurrence.

// Think of it as:
// "Find the smallest index i such that arr[i] > x"


public class UpperBound{
    public static void main(String[] args) {
        int [] arr = {2, 3, 6, 7, 8, 8, 11, 11, 11, 12};
        int x = 6;

        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
            int mid = (low + high)/2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println("The upper bound of " + x + " is: " + ans);
    }
}