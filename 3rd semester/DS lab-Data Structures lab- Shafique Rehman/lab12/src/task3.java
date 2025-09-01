import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Graph {
     final int V;
     final List<List<Integer>> adjList;

    public Graph(int v) {
        V = v;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; ++i) {
            adjList.add(new LinkedList<>());
        }
    }
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    public void print() {
        for (int i = 0; i < V; i++) {
            System.out.print("Adjacency list of vertex " + i + ": ");
            for (Integer neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
public class task3 {
    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        int[][] edges = {{0, 1}, {0, 4}, {4, 1}, {4, 3}, {1, 3}, {1, 2}, {3, 2}};

        Graph graph = new Graph(V);

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.addEdge(u, v);
        }
        graph.print();
    }
}