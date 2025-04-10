public class Number_of_powerful_integers{
    public static void main(String[] args) {
        long start = 1;
        long finish = 6000;
        int limit = 4;
        String s = "124";

        Solution sol = new Solution();
        long result = sol.numberOfPowerfulInt(start, finish, limit, s);

        System.out.println("Output: " + result);  // Expected: 5
    }
}

class Solution {
    private String suffix;
    private int limit;
    private String numStr;
    private Long[][][] memo;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.suffix = s;
        this.limit = limit;
        return countPowerfulIntegers(finish) - countPowerfulIntegers(start - 1);
    }

    private long countPowerfulIntegers(long upTo) {
        this.numStr = String.valueOf(upTo);
        int n = numStr.length();
        this.memo = new Long[n + 1][2][2];
        return dfs(0, true, false, "");
    }

    private long dfs(int pos, boolean isTight, boolean isStarted, String current) {
        if (pos == numStr.length()) {
            if (!isStarted) return 0;
            return current.endsWith(suffix) ? 1 : 0;
        }

        if (memo[pos][isTight ? 1 : 0][isStarted ? 1 : 0] != null) {
            return memo[pos][isTight ? 1 : 0][isStarted ? 1 : 0];
        }

        int upper = isTight ? numStr.charAt(pos) - '0' : 9;
        long res = 0;

        for (int digit = 0; digit <= upper; digit++) {
            if (digit > limit) continue;

            boolean nextTight = isTight && (digit == upper);
            boolean nextStarted = isStarted || digit != 0;
            String nextCurrent = nextStarted ? current + digit : current;

            res += dfs(pos + 1, nextTight, nextStarted, nextCurrent);
        }

        memo[pos][isTight ? 1 : 0][isStarted ? 1 : 0] = res;
        return res;
    }
}