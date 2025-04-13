public class Book_allocation{
    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int students = 4;

        int low = get_max(arr);
        int high = get_sum(arr);

        while (low <= high) { 
            int mid = (low + high)/2;

            if (students_required(arr, mid) > students) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("Minimum number of pages: " + low);
    }

    private static int get_max(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int get_sum(int[] arr){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static int students_required(int[] arr, int pages){
        int student = 1;
        int pagesStudent = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pagesStudent + arr[i] <= pages) {
                pagesStudent += arr[i];
            }
            else{
                student++;
                pagesStudent = arr[i];
            }
        }
        return student;
    }
}