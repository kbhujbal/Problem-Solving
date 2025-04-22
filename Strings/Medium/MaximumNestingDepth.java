public class MaximumNestingDepth{
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            else if (c == ')') {
                currentDepth--;
            }
        }
        System.out.println("Maximum Nesting Depth of Paranthesis is : " + maxDepth);
    }
}