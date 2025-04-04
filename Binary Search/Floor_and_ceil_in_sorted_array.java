

public class Floor_and_ceil_in_sorted_array{
    public static void main(String[] args) {
        int [] arr = {10, 20, 30, 40, 50};
        int x = 25;

        int [] ans = getfloorandceilvlue(arr, x);

        System.out.println("Floor value: " + ans[0]);
        System.out.println("Ceil value: " + ans[1]);
    }

    public static int [] getfloorandceilvlue(int [] arr, int x){
        int f =  getfloorvalue(arr, x);
        int c = getceilvalue(arr, x);

        return new int[] {f, c};
    }

    public static int getfloorvalue(int [] arr, int x){
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) { 
            int mid = (low + high)/2;
            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1;        
            } else { 
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int getceilvalue(int [] arr, int x){
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
            int mid = (low + high)/2;
            if (arr[mid] >= x) {
                ans = arr[mid];
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }


}