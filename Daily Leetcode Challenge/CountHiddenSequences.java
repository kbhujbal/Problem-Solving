public class CountHiddenSequences {

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, sum = 0;

        for (int diff : differences) {
            sum += diff;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        long range = (long) upper - lower;
        long possibleStarts = range - (max - min) + 1;

        return (int) Math.max(0, possibleStarts);
    }

    public static void main(String[] args) {
        // Sample test case
        int[] differences = {1, -3, 4};
        int lower = 1;
        int upper = 6;

        int result = numberOfArrays(differences, lower, upper);
        System.out.println("Number of valid hidden sequences: " + result);
    }
}
