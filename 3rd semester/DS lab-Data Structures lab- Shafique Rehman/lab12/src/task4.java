//import java.util.Arrays;
//
//class MinSpanningTree {
//     static final int V = 3;
//    int minKey(int key[], Boolean mstSet[]) {
//        int min = Integer.MAX_VALUE, min_index = -1;
//
//        for (int v = 0; v < V; v++)
//            if (mstSet[v] == false && key[v] < min) {
//                min = key[v];
//                min_index = v;
//            }
//
//        return min_index;
//    }
//    void display(int parent[], int graph[][]) {
//        System.out.println("Edge \tWeight");
//        int totalWeight = 0;
//        for (int i = 1; i < V; i++) {
//            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
//            totalWeight += graph[i][parent[i]];
//        }
//        System.out.println("Total Weight of MST: " + totalWeight);
//    }
//    void primMST(int graph[][]) {
//        int parent[] = new int[V];
//        int key[] = new int[V];
//        Boolean mstSet[] = new Boolean[V];
//
//        Arrays.fill(key, Integer.MAX_VALUE);
//        Arrays.fill(mstSet, false);
//
//        key[0] = 0;
//        parent[0] = -1;
//
//        for (int count = 0; count < V - 1; count++) {
//            int u = minKey(key, mstSet);
//            mstSet[u] = true;
//
//            for (int v = 0; v < V; v++)
//                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
//                    parent[v] = u;
//                    key[v] = graph[u][v];
//                }
//        }
//
//        display(parent, graph);
//    }
//
//}
//public class task4{
//    public static void main(String[] args) {
//        MinSpanningTree t = new MinSpanningTree();
//        int graph[][] = new int[][] {
//                { 0, 5, 2 },
//                { 5, 0, 3 },
//                { 1, 3, 0 }
//        };
//
//        t.primMST(graph);
//    }
//}
