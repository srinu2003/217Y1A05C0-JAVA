import java.util.*;

class ShortestPath {
    static class Edge { int d, w; Edge(int d, int w) { this.d = d; this.w = w; } }
    static void dijkstra(int s, List<Edge>[] g, int[] d) {
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        q.offer(new Edge(s, 0));
        while (!q.isEmpty()) {
            Edge c = q.poll();
            for (Edge n : g[c.d]) {
                int newD = d[c.d] + n.w;
                if (newD < d[n.d]) { d[n.d] = newD; q.offer(new Edge(n.d, newD)); }
            }
        }
    }
    public static void main(String[] args) {
        int n = 5;
        List<Edge>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        g[0].add(new Edge(1, 2)); g[0].add(new Edge(2, 4));
        g[1].add(new Edge(2, 1)); g[1].add(new Edge(3, 7));
        g[2].add(new Edge(3, 1)); g[2].add(new Edge(4, 3));
        g[3].add(new Edge(4, 5));
        int[] d = new int[n];
        dijkstra(0, g, d);
        for (int i = 0; i < n; i++) System.out.println("Shortest distance from 0 to " + i + ": " + d[i]);
    }
}
