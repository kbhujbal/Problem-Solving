import java.util.Arrays;

class Item{
    int value, weight;
    
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}

public class Fractional_Knapsack{
    public static void main(String[] args) {
        Item[] items = {
            new Item(100, 20),
            new Item(60, 10),
            new Item(100, 50),
            new Item(200, 50)
        };

        int capacity = 90;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum Value in Knapsack : " + maxValue);
    }

    private static double getMaxValue(Item[] items, int capacity){
        
        Arrays.sort(items, (a, b) -> 
            Double.compare((double)b.value / b.weight, (double)a.value / a.weight)
        );

        double totalValue = 0.0;

        for (Item item : items) {
            if(capacity == 0) break;

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue +=  (double)(capacity * (item.value / item.weight));
            }
        }

        return totalValue;
    }
}
