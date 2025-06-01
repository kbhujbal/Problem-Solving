public class Second_Largest_Element{
    public static void main(String[] args){
        int first_max = 0;
        int second_max = 0;
        int[] arr = {100, 90, 99, 327, 45, 83, 500};

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > second_max && arr[i] > first_max){
                second_max = first_max;
                first_max = arr[i];
            }
            else if(arr[i] > second_max && arr[i] < first_max){
                second_max = arr[i];
            }
        }
        System.out.println("The Second Largest Element in the array is : " + second_max);
    }
}