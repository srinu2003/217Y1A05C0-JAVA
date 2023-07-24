import java.util.Arrays;

public class GraphColoring {

    private int V;
    private int[] colors;
    private int[][] graph;

    public GraphColoring(int[][] graph) {
        this.graph = graph;
        V = graph.length;
        colors = new int[V];
        Arrays.fill(colors, -1);
    }

    public void graphColoring() {
        if (colorGraph(0))
            System.out.println("Graph can be colored: " + Arrays.toString(colors));
        else
            System.out.println("Graph cannot be colored.");
    }

    private boolean isSafe(int v, int c) {
        return Arrays.stream(graph[v]).noneMatch(neighbour -> c == colors[neighbour]);
    }

    private boolean colorGraph(int v) {
        if (v == V) return true;
        for (int c = 0; c < V; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;
                if (colorGraph(v + 1)) return true;
                colors[v] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };
        new GraphC(graph).graphColoring();
    }
}