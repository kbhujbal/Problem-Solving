public class First_and_last_occurence{
    public static void main(String[] args) {
        int [] arr ={2, 4, 6, 8, 8, 8, 11, 13};
        int x = 9;

        int first = LowerBound(arr, x);
        int last = UpperBound(arr, x) - 1;

        if (first == arr.length || arr[first] != x) {
            System.out.println("{-1, -1}");
        }
        else {
            System.out.println("{" + first + ", " + last + "}");
        }
    }

    public static int LowerBound(int [] arr, int x){
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
        return ans;
    }

    public static int UpperBound(int [] arr, int x){
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = (low + high)/2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}