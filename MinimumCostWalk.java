import java.util.*;

public class MinimumCostWalk {
    
    static class Node {
        int vertex;
        int andValue;

        Node(int vertex, int andValue) {
            this.vertex = vertex;
            this.andValue = andValue;
        }
    }

    public int[] minimumCostWalk(int n, int[][] edges, int[][] queries) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Build the adjacency list representation of the graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        int[] results = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            results[i] = bfsMinAndCost(graph, start, end, n);
        }

        return results;
    }

    private int bfsMinAndCost(Map<Integer, List<int[]>> graph, int start, int end, int n) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) return -1;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();

        queue.offer(new Node(start, Integer.MAX_VALUE));
        visited.put(start, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currVertex = node.vertex;
            int currAnd = node.andValue;

            if (currVertex == end) return currAnd;

            for (int[] neighbor : graph.getOrDefault(currVertex, new ArrayList<>())) {
                int nextVertex = neighbor[0];
                int edgeWeight = neighbor[1];

                int newAnd = currAnd & edgeWeight;

                if (!visited.containsKey(nextVertex) || newAnd > visited.get(nextVertex)) {
                    visited.put(nextVertex, newAnd);
                    queue.offer(new Node(nextVertex, newAnd));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumCostWalk solution = new MinimumCostWalk();
        
        int n = 4;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] queries = {{0, 3}, {3, 4}};
        
        System.out.println(Arrays.toString(solution.minimumCostWalk(n, edges, queries)));
        // Expected Output: [3, 3, 10]
    }
}
