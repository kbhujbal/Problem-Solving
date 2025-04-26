public class Atoi{
    public static void main(String[] args) {
        String s = "1337c0d3";

        int i = 0, n = s.length();
        int sign = 1;
        int result = 0;

        // Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') { 
            i++;
        }

        // Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert characters to integer
        while (i < n && Character.isDigit(s.charAt(i))) { 
            int digit = s.charAt(i) - '0'; // Convert char to int

            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;
            }

            result = result * 10 + digit;
            i++;
        }
        System.out.println("Atoi is : " + result * sign);
    }
}