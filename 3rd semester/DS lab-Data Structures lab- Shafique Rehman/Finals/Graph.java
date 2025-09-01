//not built-in graph structure
//sir wali
import java.io.*;
import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int data) { //constructor
        this.data = data;
        this.next = null;
    }
}
class Linkedlist{
    Node head;
    public Linkedlist() {
        this.head = null;
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if (head==null){
            head=newNode;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=newNode;
        }
    }
}
class Edge { // for weighted graph
    int source;
    int destination;
    int weight;
    public Edge(int source,int destination, int weight) {
        this.source= source;
        this.destination = destination;
        this.weight = weight;
    }
}

//class WeightedGraph{
//    Linkedlist<Edge> adjL= new Linkedlist();
//}

public class Graph {
    int vertices;
    Linkedlist[] adjL; // this adjacancy list is an object array that will store the addresses of each linked list.

    public Graph(int vertices) {
        this.vertices = vertices;
        adjL = new Linkedlist[vertices];

        for (int i = 0; i < vertices; i++) {
            adjL[i]= new Linkedlist();
        }
    }
    public void addEdgeU(int src, int dest){ //Un-weighted
        adjL[src].insert(dest);
        adjL[dest].insert(src);
    }
    public void addEdgeW(int src, int dest, int weight){ //Weighted
        adjL[src].insert(dest);
        adjL[dest].insert(src);
    }
    public void print(int v){ //unweighted
        for(int i =0;i<v;i++){
            System.out.println(adjL[i]);
        }
    }
    public void print() { //unweighted
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            Node temp = adjL[i].head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    //BFS - immediate neighbours, like level wise traversal, queue data structure
    //graph mei cycles hoti hain
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];

        int[] queue = new int[vertices];
        int front = 0, rear = 0;

        visited[startVertex] = true;
        queue[rear++] = startVertex;

        while (front != rear) {
            int currentVertex = queue[front++];
            System.out.print(currentVertex + " ");

            Node temp = adjL[currentVertex].head;
            while (temp != null) {
                int adjacentVertex = temp.data;
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue[rear++] = adjacentVertex;
                }
                temp = temp.next;
            }
        }
        System.out.println();
    }
//    void BFS(int s) //Geekforgeeks linkedlist queue
//    {
//        // Mark all the vertices as not visited(By default
//        // set as false)
//        boolean visited[] = new boolean[vertices];
//
//        // Create a queue for BFS
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//
//        // Mark the current node as visited and enqueue it
//        visited[s] = true;
//        queue.add(s);
//
//        while (queue.size() != 0) {
//
//            // Dequeue a vertex from queue and print it
//            s = queue.poll();
//            System.out.print(s + " ");
//
//            // Get all adjacent vertices of the dequeued
//            // vertex s.
//            // If an adjacent has not been visited,
//            // then mark it visited and enqueue it
//            Iterator<Integer> i = adjL[s].listIterator();
//            while (i.hasNext()) {
//                int n = i.next();
//                if (!visited[n]) {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
//        }
    //DFS - keep going to the first neighbour, stack or recursion

    public static void main(String[] args) {
        int V = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Vertices: ");
        int v = sc.nextInt();
        Graph graph = new Graph(v);

        graph.addEdgeU(0, 3);
        graph.addEdgeU(0, 1);
        graph.addEdgeU(0, 8);
        graph.addEdgeU(1, 7);
        graph.addEdgeU(2, 3);
        graph.addEdgeU(2, 5);
        graph.addEdgeU(2, 7);
        graph.addEdgeU(3, 4);
        graph.addEdgeU(4, 8);
        graph.addEdgeU(5, 6);

        graph.print();
        graph.BFS(0);

    }

}


