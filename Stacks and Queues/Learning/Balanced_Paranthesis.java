import java.util.*;

public class Balanced_Paranthesis{
    public static void main(String[] args) {
        String s = "(){}}{";
        
        boolean isblanaced = isBalanced(s);

        if (isblanaced) {
            System.out.println("String is Balanced");
        }
        else{
            System.out.println("String is not Balanced");
        }
    }

    private static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();

        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{') {
                stack.push(it);
            }
            else{
                if (stack.isEmpty()) {
                    return false;
                }
                char ch = stack.pop();
                if ((it == ')' && ch == '(') || (it == '}' && ch == '{') || (it == ']' && ch == '[')) {
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}