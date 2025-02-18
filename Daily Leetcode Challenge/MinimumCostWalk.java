// Leetcode 3108

import java.util.*;

public class MinimumCostWalk {

    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        // Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (u == v) {
                res[i] = 0;
            } else {
                res[i] = bfs(u, v, graph, n);
            }
        }
        return res;
    }

    private int bfs(int start, int target, Map<Integer, List<int[]>> graph, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int minCost = Integer.MAX_VALUE;

        queue.offer(new int[]{start, -1}); // -1 means all bits set

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int cost = curr[1];

            if (node == target) {
                minCost = Math.min(minCost, cost);
            }

            for (int[] nei : graph.getOrDefault(node, new ArrayList<>())) {
                int next = nei[0];
                int weight = nei[1];
                int newCost = (cost == -1) ? weight : (cost & weight);
                String state = next + ":" + newCost;

                if (!visited.contains(state)) {
                    visited.add(state);
                    queue.offer(new int[]{next, newCost});
                }
            }
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    // ✅ MAIN METHOD for local testing
    public static void main(String[] args) {
        MinimumCostWalk solver = new MinimumCostWalk();

        int n = 5;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] queries = {{0, 3}, {3, 4}};

        int[] result = solver.minimumCost(n, edges, queries);

        System.out.println("Output: " + Arrays.toString(result)); // Expected: [1, -1]
    }
}
