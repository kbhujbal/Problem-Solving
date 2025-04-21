public class Valid_Anagram{
    public static void main(String[] args) {
        boolean isAnagram = true;
        String s = "anagram";
        String t = "nagaram";

        if(s.length() != t.length()) isAnagram = false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < 26; i++){
            if (count[i] != 0) {
                isAnagram = false;
                break;
            }
        }
        System.out.println(isAnagram);
    }
}