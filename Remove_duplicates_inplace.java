public class Remove_duplicates_inplace {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3};
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n - 1];
        for (int i = 0; i < j; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("Only " + j + " unique elements are present in the array");
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)

//  Brute Force Approach: Using two pointers
// 1. Use a HashSet: Iterate through the given array and insert each element into a HashSet. This automatically removes duplicates.
// 2. Sort and Copy Back: Convert the set back into an array and overwrite nums to ensure in-place modification.
// 3. Return Unique Count: The size of the HashSet gives the number of unique elements.