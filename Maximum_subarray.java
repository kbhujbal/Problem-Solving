
public class Maximum_subarray{
    public static void main(String [] args){
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        long  maxi = Long.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];

            if (sum > maxi) {
                maxi = sum;                
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Maximum sum present in the subarray is " + maxi);
    }
}

// This problem also has a follow up question or problem to return 
// the subarray with maximum sum
// Follow up question has been solved in the same directory with the name Maximum_subarray_followup.java