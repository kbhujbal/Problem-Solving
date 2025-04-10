public class Number_of_powerful_integers {
    private String s;
    private int limit;
    private String numStr;
    private Long[][][] memo;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.s = s;
        this.limit = limit;
        return countPowerfulIntegers(finish) - countPowerfulIntegers(start - 1);
    }

    private long countPowerfulIntegers(long upTo) {
        this.numStr = String.valueOf(upTo);
        int n = numStr.length();
        this.memo = new Long[n][2][2];
        return dfs(0, true, false);
    }

    private long dfs(int pos, boolean isTight, boolean hasSuffix) {
        if (pos == numStr.length()) {
            return hasSuffix ? 1 : 0;
        }
        if (memo[pos][isTight ? 1 : 0][hasSuffix ? 1 : 0] != null) {
            return memo[pos][isTight ? 1 : 0][hasSuffix ? 1 : 0];
        }

        int upperBound = isTight ? numStr.charAt(pos) - '0' : limit;
        long count = 0;

        for (int digit = 0; digit <= upperBound; digit++) {
            if (digit > limit) continue;
            boolean newHasSuffix = hasSuffix || (digit == s.charAt(0) - '0' && pos + s.length() <= numStr.length() && numStr.startsWith(s, pos));
            count += dfs(pos + 1, isTight && (digit == upperBound), newHasSuffix);
        }

        memo[pos][isTight ? 1 : 0][hasSuffix ? 1 : 0] = count;
        return count;
    }
}
