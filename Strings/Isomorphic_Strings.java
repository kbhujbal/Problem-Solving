
import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings{
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        
        boolean isomorphic = true;

        if(s.length() != t.length()) isomorphic = false;
        
        Map<Character, Character> ST= new HashMap<>();
        Map<Character, Character> TS = new HashMap<>();   

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (ST.containsKey(ch1)) {
                if (ST.get(ch1) != ch2) {
                    isomorphic = false;
                    break;
                }
            }
            else{
                if (TS.containsKey(ch2)) {
                    isomorphic = false;
                    break;
                }
                ST.put(ch1, ch2);
                TS.put(ch2, ch1);
            }
        }

        if (isomorphic) {
            System.out.println("Strings are Isomorphic");
        }
        else{
            System.out.println("Strings are not Isomorphic");
        }
    }
}
