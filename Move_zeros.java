public class Move_zeros{
    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 12};
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[count++] = nums[i];
            }
        }
        while(count < n){
            nums[count++] = 0;
        }
        System.out.println("Array after moving zeros to the end: ");
        for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
    }
}