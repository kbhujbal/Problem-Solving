public class Rearrange_array_elements_by_sign {
    public static void main(String [] args) {
        int [] arr = {1, 2, -4, -5};
        int [] result = new int[arr.length];
        int positiveIndex = 0;
        int negativeIndex = 1;

        for(int num : arr){
            if(num > 0){
                result[positiveIndex] = num;
                positiveIndex += 2;
            }
            else{
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
        }

        for(int resnum : result){
            System.out.print(resnum + " ");
        }
    }
}
