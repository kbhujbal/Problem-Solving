public class Practice{
    public static void main(String[] args) {
        int[] arr = {1, 1, 5};

        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) { 
            i--;
        }

        int j = arr.length - 1;
        while (j >= 0 && arr[j] <= arr[i]) { 
            j--;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        
    }
}