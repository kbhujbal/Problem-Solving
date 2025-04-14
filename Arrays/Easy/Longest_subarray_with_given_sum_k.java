public class Longest_subarray_with_given_sum_k{
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 3;

        int n = arr.length;
        int maxLen = 0;

        int left = 0; 
        int right = 0;
        int sum = arr[0];

        while (right < n) {

            while (left <= right && sum > k) { 
                sum -= arr[left];
                left++;
            } 

            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        System.out.println("The length of longest subarray with sum 3 is " + maxLen);
    }
}