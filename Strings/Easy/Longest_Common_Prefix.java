public class Longest_Common_Prefix{
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    System.out.println("Longest common prefix: " + strs[0].substring(0, i));
                    return;
                }
            }
        }
        System.out.println("Longest common prefix is: " + strs[0]);
    }
}