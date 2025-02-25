public class Rotate_array_by_d_places_to_right {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;

        int n = nums.length;
        d = d % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);

        System.out.println("Rotated array by d places to right: ");
        for(int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


// Approach using extra space
// Time Complexity: O(n)    Space Complexity: O(d)  where n is the number of elements in the array  
// This approach first stores the last k elements in a temporary array. Then, it shifts the remaining elements to the right and finally places the stored elements at the beginning.


// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         k = k % n; // Handle cases where k > n
        
//         // Step 1: Store the last k elements in a temporary array
//         int[] temp = new int[k];
//         for (int i = 0; i < k; i++) {
//             temp[i] = nums[n - k + i];
//         }

//         // Step 2: Shift the remaining elements to the right
//         for (int i = n - 1; i >= k; i--) {
//             nums[i] = nums[i - k];
//         }

//         // Step 3: Place stored k elements at the beginning
//         for (int i = 0; i < k; i++) {
//             nums[i] = temp[i];
//         }
//     }
// }
