import java.util.*;

public class CompleteComponentsCounter {

    public int countCompleteComponents(int n, int[][] edges) {
        // Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> nodes = new ArrayList<>();
                dfs(i, graph, visited, nodes);

                // Count edges in this component
                int edgeCount = 0;
                for (int node : nodes) {
                    edgeCount += graph.get(node).size();
                }
                edgeCount /= 2; // Each edge counted twice

                int numNodes = nodes.size();
                int expectedEdges = numNodes * (numNodes - 1) / 2;

                if (edgeCount == expectedEdges) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> nodes) {
        visited[node] = true;
        nodes.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, nodes);
            }
        }
    }

    public static void main(String[] args) {
        CompleteComponentsCounter counter = new CompleteComponentsCounter();
        
        int n = 6;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {3, 4}
        };

        int result = counter.countCompleteComponents(n, edges);
        System.out.println("Output: " + result);  // Expected Output: 3
    }
}
