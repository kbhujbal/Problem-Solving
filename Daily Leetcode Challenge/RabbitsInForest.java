// Leetcode 781

import java.util.*;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int ans : answers) {
            if (ans == 0) {
                result++; 
            } else {
                map.put(ans, map.getOrDefault(ans, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();     
            int count = entry.getValue();
            int groupSize = x + 1;

            int groups = (count + x) / groupSize;

            result += groups * groupSize;
        }

        return result;
    }

    public static void main(String[] args) {
        RabbitsInForest obj = new RabbitsInForest();
        int[] answers = {1, 1, 2};
        System.out.println(obj.numRabbits(answers)); 
    }
}
