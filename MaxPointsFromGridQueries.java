import java.util.*;

public class MaxPointsFromGridQueries {

    static class UnionFind {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();

        String find(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                size.put(x, 1);
            }
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (rootX.equals(rootY)) return;

            int sizeX = size.getOrDefault(rootX, 1);
            int sizeY = size.getOrDefault(rootY, 1);

            if (sizeX < sizeY) {
                String temp = rootX;
                rootX = rootY;
                rootY = temp;
            }

            parent.put(rootY, rootX);
            size.put(rootX, sizeX + sizeY);
        }

        int getSize(String x) {
            return size.getOrDefault(find(x), 1);
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[m][n];

        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        int[][] indexedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            indexedQueries[i][0] = queries[i];
            indexedQueries[i][1] = i;
        }
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[0]));

        UnionFind uf = new UnionFind();
        int[] result = new int[queries.length];
        int k = 0;

        for (int[] query : indexedQueries) {
            int q = query[0];
            int idx = query[1];

            while (k < cells.size() && cells.get(k)[0] < q) {
                int[] cell = cells.get(k++);
                int x = cell[1], y = cell[2];
                visited[x][y] = true;

                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && visited[nx][ny]) {
                        uf.union(x + "," + y, nx + "," + ny);
                    }
                }
            }

            if (visited[0][0]) {
                result[idx] = uf.getSize("0,0");
            } else {
                result[idx] = 0;
            }
        }

        return result;
    }

    // Sample main method for local testing
    public static void main(String[] args) {
        MaxPointsFromGridQueries solver = new MaxPointsFromGridQueries();

        int[][] grid = {
            {1, 3, 1},
            {2, 0, 4},
            {3, 2, 1}
        };

        int[] queries = {2, 4, 5};

        int[] result = solver.maxPoints(grid, queries);
        System.out.println("Results: " + Arrays.toString(result));
    }
}
