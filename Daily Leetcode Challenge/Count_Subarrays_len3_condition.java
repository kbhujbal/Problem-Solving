public class Count_Subarrays_len3_condition{
    public static void main(String[] args){
        int[] arr = {1, 2, 1, 4, 1};

        int count = 0;

        for (int i = 0; i + 2 < arr.length; i++) {
            int mid = arr[i + 1];
            if(mid % 2 == 0 && arr[i] + arr[i + 2] == mid / 2){
                count++;
            }
        }
        System.out.println("Subarray of length 3 with the condition: " + count);
    }
}