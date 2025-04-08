// This problem wants to find the nearest integer square root of a number
// This problem doesn't aim to find the exact square root of a number

public class Finding_int_squareroot{
    public static void main(String[] args) {
        int n = 28;
        boolean found = false;

        int low = 1, high = n;

        while (low <= high) { 
            int mid = (low + high)/2;

            if (mid * mid == n) {
                System.out.println("Square root is : " + mid);
                found = true;
                break;
            }

            if(mid * mid <= n){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("Square root is : " + high);        
    }
}