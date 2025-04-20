public class Maximum_subarray_followup{
    public static void main(String[] args) {
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int start = -1;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i< arr.length; i++) {
            if(sum == 0){
                start = i;
            }

            sum = sum + arr[i];

            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;                
            }

            if(sum < 0){
                sum = 0;
            }
        }
        
        System.out.println("Maximum sum present in the subarray is " + maxi + "and the array is");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}