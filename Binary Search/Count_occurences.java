public class Count_occurences{
    public static void main(String [] args){
        int [] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;

        int first = LowerBound(arr, x);
        int last = UpperBound(arr, x) - 1;

        if (first == arr.length || arr[first] != x) {
            System.out.println("0");
        }
        else{
            System.out.println(last - first + 1);
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