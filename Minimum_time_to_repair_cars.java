import java.util.Arrays;
import java.util.Scanner;

public class Minimum_time_to_repair_cars {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks); // Sort mechanics by efficiency
        
        long left = 1, right = (long) ranks[0] * (long) cars * (long) cars; // Upper bound for time

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left; // Minimum time to repair all cars
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long carsRepaired = 0;
        for (int rank : ranks) {
            carsRepaired += (long) Math.sqrt(time / rank); // Max cars mechanic can repair in `time`
            if (carsRepaired >= cars) return true; // Stop early if we can repair all cars
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of mechanics: ");
        int n = scanner.nextInt();
        int[] ranks = new int[n];

        System.out.println("Enter ranks of mechanics:");
        for (int i = 0; i < n; i++) {
            ranks[i] = scanner.nextInt();
        }

        System.out.print("Enter number of cars to repair: ");
        int cars = scanner.nextInt();

        Minimum_time_to_repair_cars solver = new Minimum_time_to_repair_cars();
        long result = solver.repairCars(ranks, cars);

        System.out.println("Minimum time to repair all cars: " + result);
        
        scanner.close();
    }
}
