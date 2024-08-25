import java.util.*;

class Graph {
    class Edge {
        int source, finish, weight;

        Edge() {
            source = finish = weight = 0;
        }
    };

    int V, E;
    Edge edge[];

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
    void BellFord(Graph graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].source;
                int v = graph.edge[j].finish;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].finish;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        display(dist, V);
    }
    void display(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.print(dist[i] + " ");
        System.out.println();
    }


}
public class task5{
    public static void main(String[] args) {
        int V = 3;
        int E = 4;

        Graph graph = new Graph(V, E);

        graph.edge[0].source = 0;
        graph.edge[0].finish = 1;
        graph.edge[0].weight = 5;

        graph.edge[1].source = 1;
        graph.edge[1].finish = 0;
        graph.edge[1].weight = 3;

        graph.edge[2].source = 1;
        graph.edge[2].finish = 2;
        graph.edge[2].weight = -1;

        graph.edge[3].source = 2;
        graph.edge[3].finish = 0;
        graph.edge[3].weight = 1;

        System.out.println("Following edges : E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]");
        System.out.println("And Source = 2");
        graph.BellFord(graph, 2);
    }
}
