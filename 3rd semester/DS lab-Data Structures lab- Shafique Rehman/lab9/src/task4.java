//import java.util.Scanner;
//
//class Node
//{
//    int data, height;
//    Node left, right;
//
//    Node(int d)
//    {
//        data = d;
//        height = 1;
//    }
//}
//public class task4 {
//
//    Node root;
//
//    int height(Node N) {
//        if (N == null)
//            return 0;
//        return N.height;
//    }
//
//    int max(int a, int b) {
//        return (a > b) ? a : b;
//    }
//
//    Node rightRotate(Node y) {
//        Node x = y.left;
//        Node T2 = x.right;
//
//
//        x.right = y;
//        y.left = T2;
//
//
//        y.height = max(height(y.left), height(y.right)) + 1;
//        x.height = max(height(x.left), height(x.right)) + 1;
//
//
//        return x;
//    }
//
//
//    Node leftRotate(Node x) {
//        Node y = x.right;
//        Node T2 = y.left;
//
//
//        y.left = x;
//        x.right = T2;
//
//
//        x.height = max(height(x.left), height(x.right)) + 1;
//        y.height = max(height(y.left), height(y.right)) + 1;
//
//
//        return y;
//    }
//
//
//    int getBalance(Node N) {
//        if (N == null)
//            return 0;
//        return height(N.left) - height(N.right);
//    }
//
//    Node insert(Node node, int data) {
//
//        if (node == null)
//            return (new Node(data));
//
//        if (data < node.data)
//            node.left = insert(node.left, data);
//        else if (data > node.data)
//            node.right = insert(node.right, data);
//        else
//            return node;
//
//
//        node.height = 1 + max(height(node.left),
//                height(node.right));
//
//
//        int balance = getBalance(node);
//
//
//        if (balance > 1 && data < node.left.data)
//            return rightRotate(node);
//
//
//        if (balance < -1 && data > node.right.data)
//            return leftRotate(node);
//
//        if (balance > 1 && data > node.left.data) {
//            node.left = leftRotate(node.left);
//            return rightRotate(node);
//        }
//
//
//        if (balance < -1 && data < node.right.data) {
//            node.right = rightRotate(node.right);
//            return leftRotate(node);
//        }
//
//        return node;
//    }
//
//
//    Node search(Node root, int key, int count) {
//        if (root == null) {
//            return null;
//        }
//        if (root.data == key) {
//            System.out.println("key = " + key + " found at level " + count);
//            return root;
//        }
//        if (root.data < key) {
//            return search(root.right, key, count + 1);
//        } else {
//            return search(root.left, key, count + 1);
//        }
//    }
//
//
//    void preOrder(Node node) {
//        if (node != null) {
//            System.out.print(node.data + " ");
//            preOrder(node.left);
//            preOrder(node.right);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        task4 tree = new task4();
//
//        tree.root = tree.insert(tree.root, 1);
//        tree.root = tree.insert(tree.root, 2);
//        tree.root = tree.insert(tree.root, 3);
//        tree.root = tree.insert(tree.root, 4);
//        tree.root = tree.insert(tree.root, 5);
//        tree.root = tree.insert(tree.root, 6);
//        tree.root = tree.insert(tree.root, 7);
//
//        System.out.println("This is the AVL Tree in PreOrder traversal");
//        tree.preOrder(tree.root);
//        System.out.println();
//        System.out.println("Enter value to search:");
//        int x = scan.nextInt();
//        if (tree.search(tree.root, x,0) == null) {
//            System.out.println(x + " not found");
//            tree.root = tree.insert(tree.root, x);
//            System.out.println();
//            System.out.println("This is the AVL Tree in PreOrder traversal after insertion");
//            tree.preOrder(tree.root);
//        }
//        else {
//            System.out.println(x + " found");
//        }
//
//
//    }
//}
