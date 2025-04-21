public class Check_Rotation_String{
    public static void main(String[] args) {
        boolean isRotated = true;
        String s = "abcde", goal = "cdeab";

        if (s.length() != goal.length()) {
            isRotated = false;
        }

        String doubled = s + s;
        isRotated = doubled.contains(goal);

        System.out.println(isRotated);
    }
}