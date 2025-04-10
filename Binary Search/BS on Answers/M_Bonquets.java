public class M_Bonquets{
    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        int m = 3, k = 1;

        if (m*k > arr.length) {
            System.out.println("Not possible to form banquets");
        }

        int ans = -1;

        int min = get_min(arr);
        int max = get_max(arr);

        int low = min, high = max;

        while (low <= high) { 
            int mid = (low + high)/2;

            if (possible(arr, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println("Minimum possible value of the maximum element in the banquet: " + ans);
    }

    public static int get_min(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int get_max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static boolean possible(int[] arr, int m, int k, int mid){
        int cnt = 0, bonqs = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= mid) {
                cnt += 1;
            }
            else{
                bonqs += (cnt/k);
                cnt = 0;
            }
        }
        bonqs += (cnt/k);
        if (bonqs >= m) {
            return true;
        }
        else{
            return false;
        }
    }
}