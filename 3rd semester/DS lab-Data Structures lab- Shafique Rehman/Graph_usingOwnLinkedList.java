import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    LinkedList() {
        this.head = null;
    }
   public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}
class Graph_implementation_using_our_own_linkedList{
    private int vertices;
    private LinkedList[] adjL;  // this adjacancy list( an objct array that will store the addresses of each linked list.
    // where we can store the linkedlist/or adjacant list on each index of array
    public Graph_implementation_using_our_own_linkedList(int vertices) {
        this.vertices = vertices;
        adjL = new LinkedList[vertices];

        for (int i = 0; i < vertices; ++i) {
            adjL[i] = new LinkedList();
        }
    }
    public void addEdge(int source, int destination) {
        adjL[source].insert(destination);
        adjL[destination].insert(source);
    }
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
    public void print() {
        for (int i = 0; i < vertices; ++i) {
            System.out.print("Vertex " + i + " is connected to: ");
            Node temp = adjL[i].head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Vertices: ");
        int v = sc.nextInt();
        Graph_implementation_using_our_own_linkedList graph = new Graph_implementation_using_our_own_linkedList(v);

        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 8);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(3, 4);
        graph.addEdge(4, 8);
        graph.addEdge(5, 6);

        graph.print();
        graph.BFS(0);
    }
}
