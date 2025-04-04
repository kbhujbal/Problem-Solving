public class Search_insert_position{
    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 6};
        int x = 4;

        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) { 
            int mid = (low + high)/2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("The position to insert " + x + " is: " + ans);
    }
}