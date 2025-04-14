import java.util.*;

public class Zero_array_transformation2 {
    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int left = 0, right = m + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (canTransform(nums, queries, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left > m ? -1 : left;
    }

    private static boolean canTransform(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int[] tempNums = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r + 1 < n) {
                diff[r + 1] -= val;
            }
        }

        int cumulative = 0;
        for (int i = 0; i < n; i++) {
            cumulative += diff[i];
            if (tempNums[i] > cumulative) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2};
        int[][] queries = {
            {0, 2, 1},
            {0, 2, 1},
            {1, 1, 3},
        };

        int result = minZeroArray(nums, queries);
        System.out.println("Minimum queries required: " + result);
    }
}
