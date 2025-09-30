import java.util.*;

public class Infix_2_Postfix{
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)";

        String postfix = infixToPostfix(infix);
        System.out.println("Infix Expression : " + infix);
        System.out.println("Postfix Expression : " + postfix);
    }

    private static String infixToPostfix(String expression){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') { 
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && prescedence(ch) <= prescedence(stack.peek())) { 
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) { 
            result.append(stack.pop());
        }

        return result.toString();   
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int prescedence(char op){
        switch (op) {
            case '+': case '-' : return 1; 
            case '*': case '/' : return 2;
            case '^' : return 3;
            default : return -1;
        }
    }
}