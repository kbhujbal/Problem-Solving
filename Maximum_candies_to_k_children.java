import java.util.*;

public class Maximum_candies_to_k_children{
    public static int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = (int) (Arrays.stream(candies).asLongStream().sum() / k);

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canDistribute(candies, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return canDistribute(candies, k, left) ? left : left - 1;
    }

    private static boolean canDistribute(int[] candies, long k, int x) {
        long count = 0;
        for (int candy : candies) {
            count += candy / x;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        // Example Test Case
        int[] candies = {5, 8, 6}; // Given candy piles
        long k = 3; // Number of children

        int result = maximumCandies(candies, k);
        System.out.println("Maximum candies per child: " + result);
    }
}