//class Node {
//    int data;
//    Node left, right;
//
//    public Node(int item) {
//        data = item;
//        left = right = null;
//    }
//}
//public class task2 {
//    Node root;
//
//    task2(){
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
//    boolean isCompleteBT(Node root, int i, int Count) {
//        if (root == null)
//            return true;
//
//        if (i >= Count)
//            return false;
//
//        return (isCompleteBT(root.left, 2 * i + 1, Count) &&
//                isCompleteBT(root.right, 2 * i + 2, Count));
//    }
//    int countNode(Node root) {
//        if (root == null)
//            return 0;
//        return 1 + countNode(root.left) + countNode(root.right);
//    }
//
//    boolean isFullBT(Node root) {
//        if (root == null)
//            return true;
//
//        if (root.left == null && root.right == null)
//            return true;
//
//        if (root.left != null && root.right != null)
//            return (isFullBT(root.left) && isFullBT(root.right));
//
//        return false;
//    }
// Node deleteNodes(Node root, int index, int nodeCount) {
//         if (root == null)
//         return null;
//
//         root.left = deleteNodes(root.left, 2 * index + 1, nodeCount);
//         root.right = deleteNodes(root.right, 2 * index + 2, nodeCount);
//
//         if (index >= nodeCount) {
//         return null; // Deleting the nodes that exceed the count
//         }
//
//         return root;
//         }
//
//    void inorder() {
//        inorderVisit(root);
//    }
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
//        task2 tree = new task2();
//        for(int x : a){
//            tree.insert(x);
//        }
//
//        System.out.println("This is the binary tree before insertion: ");
//        tree.inorderVisit(tree.root);
//        System.out.println();
//
//        tree.insert(6);
//        tree.insert(8);
//        tree.insert(9);
//
//        int nodeCount = tree.countNode(tree.root);
//
//        System.out.println("Is the tree a complete binary tree? " + tree.isCompleteBT(tree.root, 0, nodeCount));
//        System.out.println("Is the tree a full binary tree? " + tree.isFullBT(tree.root));
//
//
//
//  if (!tree.isCompleteBT(tree.root, 0, nodeCount) || !tree.isFullBT(tree.root)) {
//          tree.root = tree.deleteNodes(tree.root, 0, nodeCount);
//          }
//
//        System.out.println("This is the binary tree after insertion:");
//        tree.inorderVisit(tree.root);
//        System.out.println();
//
//        System.out.println("Is the tree a complete binary tree? " + tree.isCompleteBT(tree.root, 0, nodeCount));
//        System.out.println("Is the tree a full binary tree? " + tree.isFullBT(tree.root));
//
//
//
//    }
//
//
//
//
//
//}


