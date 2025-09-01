//import java.util.Scanner;
//
//class Node {
//    int data;
//    Node left, right;
//
//    public Node(int item) {
//        data = item;
//        left = right = null;
//    }
//}
//public class task3 {
//    Node root;
//
//    task3(){
//        root = null;
//    }
//    void insert(int data) {
//
//        root = insertVal(root, data);
//    }
//
//    Node insertVal(Node root, int data) {
//        if (root == null) {
//            root = new Node(data);
//            return root;
//        }
//
//        if (data < root.data)
//            root.left = insertVal(root.left, data);
//
//        else if (data > root.data)
//            root.right = insertVal(root.right, data);
//
//        return root;
//
//    }
//    Node searchVal(int val, Node root) {
//        if (root == null || root.data == val) {
//            if (root != null && root.data == val) {
//                return root;
//            }
//            return null;
//        }
//
//        if (val < root.data) {
//            return searchVal(val, root.left);
//        } else {
//            return searchVal(val, root.right);
//        }
//    }
//    void Location(int val, Node root, int level) {
//        Node node = searchVal(val, root);
//        if (node == null) {
//            insert(val);
//            node = searchVal(val, root);
//            System.out.println("The data " + val + " is added in the tree.");
//
//        }
//
//        if (node == root) {
//            System.out.println("The data " + val + " is the root of the tree at level " + level + ".");
//        } else {
//            Node p = findP(root, node);
//            if (p.left == node) {
//                System.out.println("The data " + val + " is left child of " + p.data + " at level " + (level + 1) + ".");
//            } else {
//                System.out.println("The data " + val + " is right child of " + p.data + " at level " + (level + 1) + ".");
//            }
//        }
//    }
//    Node findP(Node root, Node node) {
//        if (root == null || node == null || root == node) {
//            return null;
//        }
//
//        if ((root.left == node) || (root.right == node)) {
//            return root;
//        }
//
//        Node left = findP(root.left, node);
//        if (left != null) {
//            return left;
//        }
//
//        return findP(root.right, node);
//    }
//
//
//
//    void inorderVisit(Node root) {
//        if (root != null) {
//            inorderVisit(root.left);
//            System.out.print(root.data + " -> ");
//            inorderVisit(root.right);
//        }
//    }
//    public static void main(String[] args) {
//        int[] a = {45, 10, 7, 90, 12, 50, 13, 39, 57};
//
//        task3 tree = new task3();
//        for(int x : a){
//            tree.insert(x);
//        }
//
//        System.out.println("This is the current binary tree : ");
//        tree.inorderVisit(tree.root);
//        System.out.println();
//
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the value to search:");
//        int n = scan.nextInt();
//
//        tree.Location(n, tree.root, 0);
//
//    }
//}
//
