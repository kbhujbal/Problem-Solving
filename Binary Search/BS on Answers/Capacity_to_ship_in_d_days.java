public class Capacity_to_ship_in_d_days{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        int low = get_max(arr), high = getSum(arr);
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;

            int no_of_days = get_no_of_days(arr, mid);

            if (no_of_days > days){
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        System.out.println("Number of days: " + ans);
    }

    public static int get_max(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getSum(int[] arr){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static int get_no_of_days(int[] arr, int capacity){
        int days = 1, load = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((load + arr[i]) > capacity) {
                days++;
                load = arr[i];
            } else {
                load += arr[i];  
            }
        }
        return days;
    }
}