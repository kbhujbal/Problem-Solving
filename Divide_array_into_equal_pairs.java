import java.util.HashMap;
import java.util.Map;

public class Divide_array_into_equal_pairs {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Count the frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Check if all numbers have even occurrences
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Divide_array_into_equal_pairs solution = new Divide_array_into_equal_pairs();
        
        // Example test case
        int[] nums = {3, 2, 3, 2, 2, 2};
        boolean result = solution.divideArray(nums);
        
        // Print output
        System.out.println("Can the array be divided into equal pairs? " + result);
    }
}
