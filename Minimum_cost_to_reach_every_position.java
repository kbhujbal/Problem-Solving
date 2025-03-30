public class Minimum_cost_to_reach_every_position{
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] answer = new int[n];
        
        // For each position i
        for (int i = 0; i < n; i++) {
            // We can either directly swap with position i
            answer[i] = cost[i];
            
            // Or try to find a better path through previous positions
            for (int j = 0; j < i; j++) {
                // If we can reach position j with a lower cost
                if (answer[j] < answer[i]) {
                    answer[i] = answer[j];
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Minimum_cost_to_reach_every_position solution = new Minimum_cost_to_reach_every_position();
        
        // Test case 1
        int[] cost1 = {5, 3, 4, 1, 3, 2};
        int[] result1 = solution.minCosts(cost1);
        
        // Print result
        System.out.println("Test case 1:");
        System.out.println("Input: [5, 3, 4, 1, 3, 2]");
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Verify result
        int[] expected1 = {5, 3, 3, 1, 1, 1};
        boolean isCorrect = true;
        for (int i = 0; i < result1.length; i++) {
            if (result1[i] != expected1[i]) {
                isCorrect = false;
                break;
            }
        }
        System.out.println("Test case 1 " + (isCorrect ? "passed" : "failed"));
    }
}