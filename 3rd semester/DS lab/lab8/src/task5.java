//class Node {
//    int data;
//    Node left, right;
//
//    public Node(int value) {
//        data = value;
//        left = null;
//        right = null;
//    }
//}
//
//public class task5 {
//
//    Node root;
//
//    task5() {
//        root = null;
//    }
//
//    void insert(int value) {
//        root = insertVal(root, value);
//    }
//
//    Node insertVal(Node root, int value) {
//        if (root == null) {
//            root = new Node(value);
//            return root;
//        }
//
//        if (value < root.data) {
//            root.left = insertVal(root.left, value);
//        } else if (value > root.data) {
//            root.right = insertVal(root.right, value);
//        }
//
//        return root;
//    }
//
//    Node mergeTrees(Node root1, Node root2) {
//        return merge(root1, root2);
//    }
//
//    Node merge(Node root1, Node root2) {
//        if (root1 == null) {
//            return root2;
//        }
//        if (root2 == null) {
//            return root1;
//        }
//
//        if (root1.data < root2.data) {
//            root1.right = merge(root1.right, root2);
//            return root1;
//        } else {
//            root2.left = merge(root1, root2.left);
//            return root2;
//        }
//    }
//
//    public void inOrderTraversal(Node root) {
//        if (root != null) {
//            inOrderTraversal(root.left);
//            System.out.print(root.data + " ");
//            inOrderTraversal(root.right);
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//        task5 Bst1 = new task5();
//        int[] values1 = {5, 3, 2, 4, 6};
//        for (int value : values1) {
//            Bst1.insert(value);
//        }
//        task5 Bst2 = new task5();
//        int[] values2 = {2, 1, 3, 7, 6};
//        for (int value : values2) {
//            Bst2.insert(value);
//        }
//        Node mergedRoot = Bst1.mergeTrees(Bst1.root, Bst2.root);
//
//        System.out.println("Merged BST in preorder :");
//
//        PreOrder(mergedRoot);
//
//        System.out.println();
//        System.out.println("Merged BST in inorder :");
//        InOrder(mergedRoot);
//
//        System.out.println();
//
//        System.out.println("Merged BST in postorder :");
//        PostOrder(mergedRoot);
//    }
//
//
//    static void PreOrder(Node root) {
//        if (root == null)
//            return;
//        System.out.print(root.data + " ");
//        PreOrder(root.left);
//        PreOrder(root.right);
//    }
//
//    static void InOrder(Node root) {
//        if (root == null)
//            return;
//        InOrder(root.left);
//        System.out.print(root.data + " ");
//        InOrder(root.right);
//    }
//    static void PostOrder(Node root) {
//        if (root == null)
//            return;
//        PostOrder(root.left);
//        PostOrder(root.right);
//        System.out.print(root.data);
//
//    }
//
//}




