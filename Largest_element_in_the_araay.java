public class Largest_element_in_the_araay{
    public static void main(String[] args) {
        int[] arr = {100, 99, 90, 83, 327, 45};
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("The Largest element in the array is : " + max);
    }
}