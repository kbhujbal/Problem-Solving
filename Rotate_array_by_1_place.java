public class Rotate_array_by_1_place {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int temp = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)

// Approach: Using a temporary variable
// First We collect the first element in a temporary variable.
// Then we shift all the elements to the left by one place.
// Finally, we place the first element at the end of the array.
// This approach is simple and easy to implement. It is also an in-place solution.   