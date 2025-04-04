public class LowerBound{
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        int x = 9;

        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) { 
            int mid = (low + high)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        System.out.println("The lower bound of " + x + " is: " + ans);
    }
}