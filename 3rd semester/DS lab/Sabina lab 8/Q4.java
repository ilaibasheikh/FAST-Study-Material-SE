import java.util.Scanner;
public class Q4 {
    static class Node{
        int data;
        Node left;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        Node right;
    }
    Node root;
    public void ceilAndFloor(Node root, int data, String choice) {
        if (root == null)
            return;
        if (choice.equals("ceil")) {
            if (root.data == data) {
                System.out.println("Ceiling data for " + data + " = " + (data + 1));
            } else if (data < root.data) {
                System.out.println("Ceiling data for " +data + " = " + root.data);
                ceilAndFloor(root.left, data, choice);
            } else {
                ceilAndFloor(root.right, data, choice);
            }
        } else if (choice.equals("floor")) {
            if (root.data == data) {
                System.out.println("Flooring data for " + data + " = " + (data - 1));
            } else if (data < root.data) {
                ceilAndFloor(root.left, data, choice);
            } else {
                System.out.println("Flooring data for " + data + " = " + root.data);
                ceilAndFloor(root.right, data, choice);
            }
        }
    }
    public static void main(String[] args) {
        Q4 tree=new Q4();
        tree.root=new Node(10);
        tree.root.left=new Node(5);
        tree.root.right=new Node(11);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(7);
        tree.root.left.right.right=new Node(8);

        Scanner s=new Scanner(System.in);
        System.out.println("Enter X:");
        int X= s.nextInt();

        System.out.println("Choose ceil or floor ");
        String choice=s.next();

        tree.ceilAndFloor(tree.root,X,choice);
    }
}
