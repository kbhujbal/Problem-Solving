import java.util.*;

public class Minimum_Coins{
    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int V = 49;
        int value = V;

        ArrayList<Integer> ans = new ArrayList<>();
        int n = denominations.length;

        for (int i = n - 1; i >= 0; i--) {
            while (V >= denominations[i]) { 
                V -= denominations[i];
                ans.add(denominations[i]);
            }
        }
        System.out.println("Following are the required denominations for making " + value);
        for (int note : ans) {
            System.out.print(note + ", ");
        }
    }
}