import java.util.*;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int ans : answers) {
            if (ans == 0) {
                result++; // A rabbit says no others like him => 1 rabbit
            } else {
                map.put(ans, map.getOrDefault(ans, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();     // Rabbit says x others same color
            int count = entry.getValue();
            int groupSize = x + 1;

            // Number of full groups needed
            int groups = (count + x) / groupSize;

            result += groups * groupSize;
        }

        return result;
    }

    public static void main(String[] args) {
        RabbitsInForest obj = new RabbitsInForest();
        int[] answers = {1, 1, 2};
        System.out.println(obj.numRabbits(answers)); // Output: 5
    }
}
