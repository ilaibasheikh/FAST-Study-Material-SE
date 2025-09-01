import java.util.Scanner;

class Node {
    int data, height;
    Node left, right;

    Node(int d) {
        data = d;
        height = 1;
    }
}
public class task5 {

        Node root;

        int height(Node N) {
            if (N == null)
                return 0;
            return N.height;
        }

        int getBalance(Node n) {
            if (n == null)
                return 0;
            return height(n.left) - height(n.right);
        }

        Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        Node insert(Node node, int data) {
            if (node == null)
                return (new Node(data));

            if (data < node.data)
                node.left = insert(node.left, data);
            else if (data > node.data)
                node.right = insert(node.right, data);
            else
                return node;

            node.height = 1 + Math.max(height(node.left), height(node.right));

            int balance = getBalance(node);

            if (balance > 1 && data < node.left.data)
                return rightRotate(node);

            if (balance < -1 && data > node.right.data)
                return leftRotate(node);

            if (balance > 1 && data > node.left.data) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balance < -1 && data < node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }
    void getHeights(Node node) {
        if (node == null)
            return;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        System.out.println("Left side height: " + leftHeight);
        System.out.println("Right side height: " + rightHeight);
    }
    void kthSmallestAndLargest(int k) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        int[] count = {0};

        kthSmallest(root, k, count);

        count[0] = 0;
        kthLargest(root, k, count);

        getHeights(root);
    }
        void kthSmallest(Node node, int k, int[] count) {
            if (node == null || count[0] >= k)
                return;

            kthSmallest(node.left, k, count);

            count[0]++;

            if (count[0] == k) {
                System.out.println(k + "th smallest element is " + node.data);
                return;
            }

            kthSmallest(node.right, k, count);
        }


        void kthLargest(Node node, int k, int[] count) {
            if (node == null || count[0] >= k)
                return;

            kthLargest(node.right, k, count);

            count[0]++;

            if (count[0] == k) {
                System.out.println(k + "th largest element is " + node.data);
                return;
            }

            kthLargest(node.left, k, count);
        }




        void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            task5 tree = new task5();

            tree.root = tree.insert(tree.root, 1);
            tree.root = tree.insert(tree.root, 2);
            tree.root = tree.insert(tree.root, 3);
            tree.root = tree.insert(tree.root, 4);
            tree.root = tree.insert(tree.root, 5);
            tree.root = tree.insert(tree.root, 6);
            tree.root = tree.insert(tree.root, 7);
                    System.out.println("This is the AVL Tree in PreOrder traversal");
        tree.preOrder(tree.root);
            System.out.println();

            System.out.println("Enter the value of k (which kth smallest and largest element):");
            int k = scan.nextInt();

            tree.kthSmallestAndLargest(k);
        }
    }

