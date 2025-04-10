public class Number_of_powerful_integers {

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
    
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.suffix = s;
        this.limit = limit;
        return countUpTo(finish) - countUpTo(start - 1);
    }

    private long countUpTo(long num) {
        String strNum = String.valueOf(num);
        return dfs(strNum, 0, true, "", new Long[strNum.length()][2][]);
    }

    private long dfs(String num, int pos, boolean tight, String curr, Long[][][] dp) {
        if (pos == num.length()) {
            if (curr.length() < suffix.length()) return 0;
            if (curr.endsWith(suffix)) return 1;
            return 0;
        }

        int t = tight ? 1 : 0;
        if (dp[pos][t] == null) dp[pos][t] = new Long[10000];  // 10^4 digits just to be safe (curr string cache)
        int currHash = curr.hashCode() & 0x7FFFFFFF; // positive hash as index
        currHash %= 10000;

        if (dp[pos][t][currHash] != null) return dp[pos][t][currHash];

        long res = 0;
        int maxDigit = tight ? num.charAt(pos) - '0' : 9;

        for (int d = 0; d <= maxDigit; d++) {
            if (d > limit) continue;

            String next = (curr.equals("0") ? "" : curr) + d;
            boolean nextTight = tight && (d == maxDigit);
            res += dfs(num, pos + 1, nextTight, next, dp);
        }

        dp[pos][t][currHash] = res;
        return res;
    }
}
