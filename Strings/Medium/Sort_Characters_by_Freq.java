import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_by_Freq{
    public static void main(String[] args){
        String s = "tree";

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        maxHeap.addAll(freqMap.keySet());

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) { 
            char c = maxHeap.poll();
            int count = freqMap.get(c);
            result.append(String.valueOf(c).repeat(count));
        }

        System.out.println(result.toString());
    }
}