import java.util.*;

public class Count_subarray_sum_equals_k{
    public static void main(String[] args) {
        int [] arr = {3, 1, 2, 4};
        int k = 6;

        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int count = 0, preSum = 0;

        mpp.put(0, 1);

        for (int i = 0; i < n; i++) {
            preSum += arr[i];

            int remove = preSum - k;

            count += mpp.getOrDefault(remove, 0);

            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(count);
    }
}