import java.lang.*;
import java.util.*;

class SmallestPath {
    static final int V = 6;
    int minDis(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
    void printPath(int[] pred, int dest) {
        if (dest == -1) {
            return;
        }
        printPath(pred, pred[dest]);
        System.out.print(dest + " ");
    }
    void display(int dist[], int dest, int[] pred) {
        System.out.println("Shortest distance from source to destination (" + dest + "): " + dist[dest]);

        System.out.print("Shortest path: ");
        printPath(pred, dest);
        System.out.println();
    }
    void dijkstra(int graph[][], int start, int fin) {
        int dist[] = new int[V];
        int pred[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);

        dist[start] = 0;
        pred[start] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minDis(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pred[v] = u;
                }
            }
        }
        display(dist, fin, pred);
    }



}
public class task2{
    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 1, 5, 0, 0, 0 },
                { 0, 0, 2, 2, 1, 0 },
                { 0, 0, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 3, 1 },
                { 0, 0, 0, 0, 0, 2 },
                { 0, 0, 0, 0, 0, 0 }
        };
        System.out.println("let s = 0 , a = 1 , b = 2 , c = 3 , d = 4 , e = 5");
        SmallestPath t = new SmallestPath();
        t.dijkstra(graph, 0, 5);
    }
}
