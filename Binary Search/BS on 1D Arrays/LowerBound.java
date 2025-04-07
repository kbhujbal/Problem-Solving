// Lower Bound
// The lower bound of a value x in a sorted array is the first position where x can be inserted without changing the order of the array.
// In other words:

// It returns the index of the first element that is not less than x.

// If x exists, it points to the first occurrence.

// If x doesn't exist, it tells where x can be inserted.

// Think of it as:
// "Find the smallest index i such that arr[i] >= x"

public class LowerBound{
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        int x = 9;

        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) { 
            int mid = (low + high)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        System.out.println("The lower bound of " + x + " is: " + ans);
    }
}

