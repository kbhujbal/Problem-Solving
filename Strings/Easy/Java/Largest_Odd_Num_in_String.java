

public class Largest_Odd_Num_in_String{
    public static void main(String[] args) {
        boolean found = false;
        String s = "13579";
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if ((c - '0') % 2 == 1) {
                System.out.println(s.substring(0, i + 1));
                found = true;
            }
        }
        if (!found) {
            System.out.println(" ");
        }
    }
}