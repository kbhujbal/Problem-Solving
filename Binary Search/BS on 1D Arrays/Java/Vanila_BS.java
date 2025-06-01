public class Vanila_BS{
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 15;
        int left = 0, right = arr.length - 1;

        while (left <= right) { 
            int mid = (left + right)/2; 
            if (arr[mid] == target) {
                System.out.println("Target element found at index :" + mid );
                break;
            }           
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if (left > right) {
            System.out.println("Target element not found");
        }
    }
}