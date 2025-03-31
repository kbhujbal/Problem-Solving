import java.util.Arrays;

public class PutMarblesInBags {

    public static int putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1) return 0;  // Only one bag, no cuts

        // Calculate adjacent pair sums
        int[] pairSums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairSums[i] = weights[i] + weights[i + 1];
        }

        // Sort the pair sums
        Arrays.sort(pairSums);

        int maxCost = 0, minCost = 0;
        // Sum largest (k - 1) for maxCost
        for (int i = n - 2; i >= n - k; i--) {
            maxCost += pairSums[i];
        }
        // Sum smallest (k - 1) for minCost
        for (int i = 0; i < k - 1; i++) {
            minCost += pairSums[i];
        }

        return maxCost - minCost;
    }

    public static void main(String[] args) {
        // Example Input
        int[] weights = {1, 3, 5, 1};
        int k = 2;

        // Expected Output: 4
        int result = putMarbles(weights, k);
        System.out.println("Output: " + result);
    }
}
