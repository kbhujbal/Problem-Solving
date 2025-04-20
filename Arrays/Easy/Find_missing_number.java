

public class Find_missing_number{
    public static void main(String[] args){
        int [] arr = {0, 1, 2, 3, 4, 6};
        int n = arr.length;
        int sum = n * (n + 1) / 2;
        for(int i = 0; i < n; i++){
            sum -= arr[i];
        }
        System.out.println("Missing number is: " + sum);

        // Alternate approach using XOR (Faster than previous approach)
        // int [] arr = {0, 1, 2, 3, 4, 6};
        // int missing = arr.length;

        // for(int i = 0; i < arr.length; i++){
        //     missing ^= i ^ arr[i];
        // }
        // System.out.println("Missing number is: " + missing);
    }
}