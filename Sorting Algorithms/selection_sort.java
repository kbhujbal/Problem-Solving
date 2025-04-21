public class selection_sort {
    public static void main(String[] args){
        int[] arr = {5, 4, 3, 2, 1};

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int temp = 0;
                if (arr[i] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println("TheSorted Array is : ");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}