import java.util.Arrays;

public class PutMarblesInBags {

    public static int putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1) return 0;  

        int[] pairSums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairSums[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairSums);

        int maxCost = 0, minCost = 0;
        for (int i = n - 2; i >= n - k; i--) {
            maxCost += pairSums[i];
        }

        for (int i = 0; i < k - 1; i++) {
            minCost += pairSums[i];
        }

        return maxCost - minCost;
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 1};
        int k = 2;

        int result = putMarbles(weights, k);
        System.out.println("Output: " + result);
    }
}
