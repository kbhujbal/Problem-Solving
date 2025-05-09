public class pow_recursion{
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;

        System.out.println("Result : " + power(x, n));
    }

    public static double power(double x, int n){
        if(n < 0){
            x = 1 / x;
            n = -n;
        }

        return powerRecursive(x, n);
    }

    private static double powerRecursive(double x, int n){
        if (n == 0) {
            return 1;
        }

        double half = powerRecursive(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }
        else{
            return half * half * x;
        }
    }
}