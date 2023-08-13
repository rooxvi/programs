package io.ravi.graph;

public class UndirectedGraphMatrix {

    private int v; // Number of vertices in Graph
    private int e; // Number of edges in graph
    int[][] adjMatrix;

    public UndirectedGraphMatrix(int nodes) {
        this.v = nodes;
        this.e = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1; // Because it is an undirected graph
        e++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(v + " vertices, " + e + " edges " + "\n");
        for (int vertex = 0; vertex < v; vertex++) {
            sb.append(vertex + ": ");
            for (int w : adjMatrix[vertex]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraphMatrix graph = new UndirectedGraphMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        System.out.println(graph);
        // System.out.println(Arrays.deepToString(graph.adjMatrix));
    }

}
