public class check_if_array_is_sorted_rotated{
    public static void main(String[] args){
        int []nums = {3, 4, 5, 5, 1, 2};
        boolean check = check_array(nums);

        if (check == true){
            System.out.println("The array is sorted and rotated");
        }
        else{
            System.out.println("The array is not sorted and rotated");  
            
        }
    }

    public static boolean check_array(int []nums){
        int n = nums.length;
        int count = 1;

        for(int i = 1; i < 2*n; i++){
            if(nums[(i - 1) % n] <= nums[(i % n)]){
                count += 1;
            }
            else{
                count = 1;
            }
            if (count == n) {
                return true;
            }
        }
        return false;
    }
}