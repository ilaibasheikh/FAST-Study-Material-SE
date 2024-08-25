//class Node {
//    int data, height;
//    Node left, right;
//
//    Node(int d) {
//        data = d;
//        height = 1;
//    }
//}
//public class task1 {
//        Node root;
//
//
//        int height(Node N) {
//            if (N == null)
//                return 0;
//
//            return N.height;
//        }
//
//
//        int max(int a, int b) {
//            return (a > b) ? a : b;
//        }
//
//
//        Node rightRotate(Node y) {
//            Node x = y.left;
//            Node T = x.right;
//
//
//            x.right = y;
//            y.left = T;
//
//
//            y.height = max(height(y.left), height(y.right)) + 1;
//            x.height = max(height(x.left), height(x.right)) + 1;
//
//
//            return x;
//        }
//
//        Node leftRotate(Node x) {
//            Node y = x.right;
//            Node T = y.left;
//
//
//            y.left = x;
//            x.right = T;
//
//
//            x.height = max(height(x.left), height(x.right)) + 1;
//            y.height = max(height(y.left), height(y.right)) + 1;
//
//
//            return y;
//        }
//
//
//        int getBalance(Node N) {
//            if (N == null)
//                return 0;
//
//            return height(N.left) - height(N.right);
//        }
//
//        Node insert(Node node, int data) {
//
//            if (node == null)
//                return (new Node(data));
//
//            if (data < node.data)
//                node.left = insert(node.left, data);
//            else if (data > node.data)
//                node.right = insert(node.right, data);
//            else
//                return node;
//
//
//            node.height = 1 + max(height(node.left),
//                    height(node.right));
//
//            int balance = getBalance(node);
//
//            if (balance > 1 && data < node.left.data)
//                return rightRotate(node);
//
//            if (balance < -1 && data > node.right.data)
//                return leftRotate(node);
//
//            if (balance > 1 && data > node.left.data) {
//                node.left = leftRotate(node.left);
//                return rightRotate(node);
//            }
//
//            if (balance < -1 && data < node.right.data) {
//                node.right = rightRotate(node.right);
//                return leftRotate(node);
//            }
//
//            return node;
//        }
//
//        void preOrder(Node node) {
//            if (node != null) {
//                System.out.print(node.data + " ");
//                preOrder(node.left);
//                preOrder(node.right);
//            }
//        }
//
//        public static void main(String[] args) {
//            task1 tree = new task1();
//
//
//            tree.root = tree.insert(tree.root, 1);
//            tree.root = tree.insert(tree.root, 2);
//            tree.root = tree.insert(tree.root, 3);
//            tree.root = tree.insert(tree.root, 4);
//            tree.root = tree.insert(tree.root, 5);
//            tree.root = tree.insert(tree.root, 6);
//            tree.root = tree.insert(tree.root, 7);
//
//            System.out.println("This is the AVL Tree in preorder traversal");
//            tree.preOrder(tree.root);
//        }
//    }
//
//
