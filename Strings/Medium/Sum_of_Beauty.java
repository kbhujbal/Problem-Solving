public class Sum_of_Beauty{
    public static void main(String[] args) {
        String s = "aabcb";
        int totalBeauty = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                totalBeauty += calculateBeauty(freq);
            }
        }
        System.out.println(totalBeauty);
    }

    private static int calculateBeauty(int[] freq){
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (int count : freq) {
            if (count > 0) {
                maxFreq = Math.max(maxFreq, count);
                minFreq = Math.min(minFreq, count);
            }
        }
        return maxFreq - minFreq;
    }
}