public class Find_Peak_Element{
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        boolean peak = false;

        if (arr.length == 1) {
            System.out.println("Peak Element is : " + arr[0]);
            peak = true;
        }
        if (arr[0] > arr[1]) {
            System.out.println("The peak element is : " + arr[0]);
            peak = true;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            System.out.println("The peak element is : " + arr[arr.length - 1]);
            peak = true;
        }

        int low = 1, high = arr.length - 2;

        while(low <= high){
            int mid = (low + high)/2;

            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                System.out.println("The peak element is : " + arr[mid]);
                peak = true;
                break;
            }
            else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if(!peak){
            System.out.println("No peak element found");
        }
    }
}