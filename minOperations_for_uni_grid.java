import java.util.Arrays;

public class minOperations_for_uni_grid {
    public static void main(String[] args) {
        int[][] grid = {
            {2, 4},
            {6, 8}
        };
        int x = 2;
        // Output: 4
        minOperations_for_uni_grid solver = new minOperations_for_uni_grid();
        int result = solver.minOperations(grid, x);
        System.out.println("Minimum operations: " + result);
    }

    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int[] flat = new int[size];

        int index = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flat[index++] = val;
            }
        }

        int remainder = flat[0] % x;
        for (int num : flat) {
            if (num % x != remainder) {
                return -1;
            }
        }

        Arrays.sort(flat);
        int median = flat[size / 2];

        int operations = 0;
        for (int num : flat) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
