import java.util.*;

public class Element_occurs_more_than_half {
    public static void main(String[] args) {
        int [] arr = {2, 2, 1, 1, 1, 2, 2};

        HashMap <Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if (hm.containsKey(arr[i])) {
                int value = hm.get(arr[i]);
                hm.put(arr[i], value + 1);   
            }
            else{
                hm.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> it : hm.entrySet()) {
            if (it.getValue() > arr.length / 2) {
                System.out.println(it.getKey());
            }
        }
    }
}