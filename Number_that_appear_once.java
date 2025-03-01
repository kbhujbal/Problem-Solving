public class Number_that_appear_once{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 7, 6, 7};
        int n = arr.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            res = res ^ arr[i];
        }
        System.out.println("All numbers in the array appear twice except " + res);
    }
}