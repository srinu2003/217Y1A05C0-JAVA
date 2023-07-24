import java.util.Arrays;

public class TSPDynamic {

    private int V;
    private int[][] graph;
    private int[][] dp;

    public TSPDynamic(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.dp = new int[V][1 << V];
        for (int[] row : dp) Arrays.fill(row, -1);
    }

    private int tsp(int current, int mask) {
        if (mask == (1 << V) - 1) return graph[current][0];
        if (dp[current][mask] != -1) return dp[current][mask];

        int minCost = Integer.MAX_VALUE;
        for (int next = 0; next < V; next++) {
            if (next != current && (mask & (1 << next)) == 0) {
                int newMask = mask | (1 << next);
                int cost = graph[current][next] + tsp(next, newMask);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[current][mask] = minCost;
    }

    public int minCost() {
        return tsp(0, 1);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        TSPDynamic tspDP = new TSPDynamic(graph);
        int minCost = tspDP.minCost();
        System.out.println("Minimum cost to visit all cities and return to starting city: " + minCost);
    }
}
