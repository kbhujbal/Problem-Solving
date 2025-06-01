// Book Allocation Problem, Painter's Partition Problem, 
// and Split Array Largest Sum Problem are all variations of the same problem.

public class Split_array_largest_sum{
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 8, 10};
        int k = 2;

        int low = get_max(arr);
        int high = get_sum(arr);

        while (low <= high) { 
            int mid = (low + high)/2;

            if (splits_required(arr, mid) > k) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("Minmum Number : " + low);
    }


    private static int get_max(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int get_sum(int[] arr){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static int splits_required(int[] arr, int pages){
        int student = 1;
        int eachSplit = 0;

        for (int i = 0; i < arr.length; i++) {
            if (eachSplit + arr[i] <= pages) {
                eachSplit += arr[i];
            }
            else{
                student++;
                eachSplit = arr[i];
            }
        }
        return student;
    }
}