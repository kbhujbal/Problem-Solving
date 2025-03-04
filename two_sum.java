import java.util.*;

public class two_sum{
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int complement = target - arr[i];

            if (hm.containsKey(complement)) {
                result.add(hm.get(complement));
                result.add(i);
            }
            hm.put(arr[i], i);
        }
        System.out.println(result);
    }
}