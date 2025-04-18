public class Remove_Outermost_Parathesis{
    public static void main(String[] args) {
        String input = "()()";

        StringBuilder result = new StringBuilder();
        int depth = 0;

        for(char c : input.toCharArray()){
            if (c == '(') {
                if (depth > 0) {
                    result.append(c);
                }
                depth++;
            }
            else{
                depth--;
                if(depth > 0){
                    result.append(c);
                }
            }
        }
        System.out.println(result.toString());
    }
}