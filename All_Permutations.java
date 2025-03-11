import java.util.ArrayList;
import java.util.List;

public class All_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Skip if the element is already in the list
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        All_Permutations solution = new All_Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        
        // Print the permutations
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}