import java.util.*;

public class Words_Containing_Char {
    private static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"leet", "code", "hello", "world"};
        char x = 'e';
        System.out.println(findWordsContaining(words, x)); 
    }
}
