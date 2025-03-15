
public class Reverse_integer {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10; 
            x /= 10; 

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            rev = rev * 10 + digit; 
        }
        return rev;
    }

    public static void main(String[] args) {
        Reverse_integer solution = new Reverse_integer();
        
        // Example test cases
        int num1 = 123;
        int num2 = -456;
        int num3 = 1534236469; 

        System.out.println("Reverse of " + num1 + ": " + solution.reverse(num1)); 
        System.out.println("Reverse of " + num2 + ": " + solution.reverse(num2)); 
        System.out.println("Reverse of " + num3 + ": " + solution.reverse(num3)); 
    }
}
