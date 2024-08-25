//class Node {
//    int data;
//    Node left, right;
//
//    public Node(int item) {
//        data = item;
//        left = right = null;
//    }
//}
//public class task1 {
//    Node root;
//
//    task1(){
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
//        task1 tree = new task1();
//        for(int x : a){
//            tree.insert(x);
//    }
//
//        System.out.println("This is the binary tree: ");
//        tree.inorderVisit(tree.root);
//}
//
//
//
//
//}

