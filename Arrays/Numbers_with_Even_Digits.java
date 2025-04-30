public class Numbers_with_Even_Digits{
    public static void main(String[] args) {
        int[] arr = {12, 345, 2, 6, 7896};
        int cnt = 0;

        for(int num : arr){
            if ((int)(Math.log10(num) + 1) % 2 == 0) {
                cnt++;
            }
        }
        System.out.println("Array contains " + cnt + " elements with even number of digits.");
    }
}