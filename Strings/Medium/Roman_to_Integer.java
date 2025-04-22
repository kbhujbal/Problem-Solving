public class Roman_to_Integer{
    public static void main(String[] args) {
        String s = "MCMXCIV";

        int sum = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = 0;

            if(c == 'I') val = 1;
            else if(c == 'V') val = 5;
            else if(c == 'X') val = 10;
            else if(c == 'L') val = 50;
            else if(c == 'C') val = 100;
            else if(c == 'D') val = 500;
            else if(c == 'M') val = 1000;

            if(val < prev) sum -= val;
            else sum += val;

            prev = val;
        }
        System.out.println("The integer value of the Roman numeral " + s + " is: " + sum);
    }
}