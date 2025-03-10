import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Count_of_substrings_containing_K_vowels {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input string: ");
        String word = scanner.nextLine();

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        long result = countOfSubstrings(word, k);
        System.out.println("Count of substrings: " + result);

        scanner.close();
    }

    public static long countOfSubstrings(String word, int k) {
        return substringsWithAtMost(word, k) - substringsWithAtMost(word, k - 1);
    }

    private static long substringsWithAtMost(String word, int k) {
        if (k < 0) return 0;

        long result = 0;
        int vowelCount = 0;
        int uniqueVowelCount = 0;
        Map<Character, Integer> vowelLastSeen = new HashMap<>();
        int left = 0;

        for (int right = 0; right < word.length(); ++right) {
            char currentChar = word.charAt(right);
            if (isVowel(currentChar)) {
                vowelCount++;
                if (!vowelLastSeen.containsKey(currentChar) || vowelLastSeen.get(currentChar) < left) {
                    uniqueVowelCount++;
                }
                vowelLastSeen.put(currentChar, right);
            }
            while (right - left + 1 - vowelCount > k) {
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    vowelCount--;
                    if (vowelLastSeen.get(leftChar) == left) {
                        uniqueVowelCount--;
                    }
                }
                left++;
            }
            if (uniqueVowelCount == 5) {
                int minVowelLastSeen = Integer.MAX_VALUE;
                for (char vowel : "aeiou".toCharArray()) {
                    minVowelLastSeen = Math.min(minVowelLastSeen, vowelLastSeen.get(vowel));
                }
                result += minVowelLastSeen - left + 1;
            }
        }
        return result;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
