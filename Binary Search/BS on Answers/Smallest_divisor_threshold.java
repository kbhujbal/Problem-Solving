public class Smallest_divisor_threshold{
    public static void main(String[] args){
        int[] arr = {1, 2, 5, 9};
        int threshold = 6;

        int low = 0, high = get_max(arr);
        int ans = 0;

        while (low <= high) { 
            int mid = (low + high)/2;

            if (sumOfD(arr, threshold, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Smallest divisor is : " + ans);
    }

    public static int get_max(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int sumOfD(int[] arr, int threshold, int mid){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += (arr[i] + mid - 1)/mid;
        }
        return sum;
    }
}