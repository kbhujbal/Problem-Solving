public class Minimum_cost_to_reach_every_position{
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = cost[i];
            
            for (int j = 0; j < i; j++) {
                if (answer[j] < answer[i]) {
                    answer[i] = answer[j];
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Minimum_cost_to_reach_every_position solution = new Minimum_cost_to_reach_every_position();
        
        int[] cost1 = {5, 3, 4, 1, 3, 2};
        int[] result1 = solution.minCosts(cost1);
        
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