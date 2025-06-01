public class K_th_missing_number{
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        int low = 0, high = arr.length - 1;

        while(low <= high){
            int mid = (low + high)/2;

            // Calculate the number of missing numbers till arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        // answer will be arr[high] + more missing numbers (in this case it's 2)
        // because at mid there are 3 missing numbers, but we need 5, hence more 2 numbers required
        // But more = k - missing
        // missing = arr[high] - (high + 1)
        // So, we need to add more = k - (arr[high] - (high + 1)) = k - arr[high] + high + 1
        // So, the answer will be arr[high] + more = arr[high] + k - arr[high] + high + 1
        // So, the answer will be k + high + 1
        System.out.println(k + "th missing number is : " + (high + k + 1));
    }
}