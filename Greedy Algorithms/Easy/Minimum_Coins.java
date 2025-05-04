import java.util.*;

public class Minimum_Coins{
    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int V = 99;
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

// This solution for the question is not always correct. 
// Let's consider the following example :
// denominations = {1, 5, 6, 9};
// V = 11
// This solution will give {9, 1, 1} as the output, but {5, 6} is the solution,
// because it requires less number of denominations