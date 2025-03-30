public class LongestPalindromeAfterConcat {

    // Check if a string is palindrome
    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // Main logic to find the longest palindrome after concatenating substrings
    public static int longestPalindrome(String s, String t) {
        int maxLen = 0;

        // Try all possible substrings from s
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String subS = s.substring(i, j);

                // Try all possible substrings from t
                for (int k = 0; k <= t.length(); k++) {
                    for (int l = k; l <= t.length(); l++) {
                        String subT = t.substring(k, l);
                        String combined = subS + subT;

                        if (isPalindrome(combined)) {
                            maxLen = Math.max(maxLen, combined.length());
                        }
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Example 1
        String s = "a";
        String t = "a";
        int result = longestPalindrome(s, t);
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s + "\", t = \"" + t + "\"");
        System.out.println("Output: " + result); // Expected: 2
    }
}
