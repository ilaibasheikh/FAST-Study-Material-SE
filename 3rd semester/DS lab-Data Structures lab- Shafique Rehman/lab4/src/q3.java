//class task3 {
//
//    class Node {
//        int data;
//        Node next;
//
//        public Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    Node head;
//
//    public task3() {
//        this.head = null;
//    }
//
//
//    public void delete(int value) {
//        if (head == null) {
//            System.out.println("The list is empty.");
//            return;
//        }
//
//        if (head.data == value) {
//            head = head.next;
//            return;
//        }
//
//        Node current = head;
//        Node previous = null;
//
//        while (current != null && current.data != value) {
//            previous = current;
//            current = current.next;
//        }
//
//        if (current == null) {
//            System.out.println("Value " + value + " is not present in the list.");
//        } else {
//            previous.next = current.next;
//            System.out.println("Value " + value + " deleted from the list.");
//        }
//    }
//    public void display() {
//        Node current = head;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//    public void insert(int data) {
//        Node newNode = new Node(data);
//        if (head == null) {
//            head = newNode;
//        } else {
//            Node current = head;
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = newNode;
//        }
//    }
//
//
//    public class Main {
//        public static void main(String[] args) {
//            task3 list = new task3();
//            list.insert(1);
//            list.insert(2);
//            list.insert(3);
//            list.insert(4);
//            list.insert(5);
//
//            System.out.println("Original List:");
//            list.display();
//
//            list.delete(3);
//            System.out.println("List after deleting 3:");
//            list.display();
//
//            list.delete(6);
//        }
//    }
//
//
//
//
//
//
//}


