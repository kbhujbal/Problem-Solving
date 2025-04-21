public class Maximum_nummber_of_ones{
    public static void main(String[] args){
        int [] arr = {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1};

        int count = 0;
        int maximum_count = 0;

        for(int num : arr){
            if (num == 1){
                count++;
                maximum_count = Math.max(maximum_count, count);
            }
            else{
                count = 0;
            }
        }
        System.out.println("Maximum Number of ones in the array is: " + maximum_count);
    }
}