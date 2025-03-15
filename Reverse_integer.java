import java.util.*;

public class Reverse_integer {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10; // Extract last digit
            x /= 10; // Remove last digit

            // Overflow check before updating rev
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            rev = rev * 10 + digit; // Append digit to rev
        }
        return rev;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Reverse_integer solution = new Reverse_integer();
        
        // Example test cases
        int num1 = 123;
        int num2 = -456;
        int num3 = 1534236469; // Overflow case

        System.out.println("Reverse of " + num1 + ": " + solution.reverse(num1)); // Expected Output: 321
        System.out.println("Reverse of " + num2 + ": " + solution.reverse(num2)); // Expected Output: -654
        System.out.println("Reverse of " + num3 + ": " + solution.reverse(num3)); // Expected Output: 0 (overflow)
    }
}
