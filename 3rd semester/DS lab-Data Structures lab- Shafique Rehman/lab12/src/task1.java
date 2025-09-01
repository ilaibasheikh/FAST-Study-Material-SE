import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    LinkedList<Integer> adj[];
    public Graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    public void DFS(int begin) {
        boolean[] visited = new boolean[adj.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(begin);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                for (int neighbor : adj[current]) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }
    public void BFS(int begin) {
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[begin] = true;
        queue.add(begin);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

}

public class task1 {
    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 8);
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 7);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        graph.addEdge(5, 6);
        graph.addEdge(7, 2);
        graph.addEdge(8, 4);

        System.out.println("BFS from vertex 0:");
        graph.BFS(0);

        System.out.println("DFS from vertex 0:");
        graph.DFS(0);
    }
}

 