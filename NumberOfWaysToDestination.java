import java.util.*;

public class NumberOfWaysToDestination {
    static class Pair {
        int node, time;
        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

    
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new Pair(v, t));
            graph.get(v).add(new Pair(u, t));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int currTime = current.time;

            if (currTime > dist[u]) continue;

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.node;
                int time = neighbor.time;
                int newTime = currTime + time;

                if (newTime < dist[v]) {
                    dist[v] = newTime;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v, newTime));
                } else if (newTime == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
            {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3},
            {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1},
            {0, 4, 5}, {4, 6, 2}
        };
        int result = countPaths(n, roads);
        System.out.println("Output: " + result);
    }
}
