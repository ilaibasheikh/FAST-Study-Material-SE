//import java.util.Scanner;
//
//class Node {
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//        next = null;
//    }
//}
//public class task2 {
//    public static Node rotateLinkedList(Node head, int n) {
//        if (head == null || n == 0) {
//            return head;
//        }
//
//        Node current = head;
//        int count = 1;
//
//        while (count < n && current != null) {
//            current = current.next;
//            count++;
//        }
//
//        if (current == null) {
//            return head;
//        }
//
//        Node nthNode = current;
//        while (current.next != null) {
//            current = current.next;
//        }
//
//        current.next = head;
//        head = nthNode.next;
//        nthNode.next = null;
//
//        return head;
//    }
//
//    public static void printList(Node head) {
//        Node current = head;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Node head = null;
//        Node tail = null;
//
//        System.out.print("Enter the number of elements in the list: ");
//        int n = scanner.nextInt();
//
//        System.out.print("Enter the elements of the list: ");
//        for (int i = 0; i < n; i++) {
//            int data = scanner.nextInt();
//            Node newNode = new Node(data);
//            if (head == null) {
//                head = newNode;
//                tail = newNode;
//            } else {
//                tail.next = newNode;
//                tail = newNode;
//            }
//        }
//
//        System.out.print("Enter the number of elements to rotate: ");
//        int k = scanner.nextInt();
//
//        head = rotateLinkedList(head, k);
//
//        System.out.println("After rotation:");
//        printList(head);
//
//    }
//}

