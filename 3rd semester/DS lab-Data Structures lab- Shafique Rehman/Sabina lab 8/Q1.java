public class Q1 {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public Q1() {
        this.root =null;
    }
    Node root;
    void insert(int data) {
        root = insertRec(root, data);
    }
    Node insertRec(Node root, int data){
        if (root == null) {
            root = new Node(data);
            return root;
        }
        else if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data> root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + "->");
            inorderRec(root.right);
        }
    }
    void inorder() {
        inorderRec(root);
    }
    public static void main(String[] args) {
        int[] array={45, 10, 7, 90, 12, 50, 13, 39, 57};
        Q1 BST=new Q1();
        int n= array.length-1;
        for(int i=0;i<n;i++){
            BST.insert( array[i]);
        }
        System.out.println("Inorder Traversal");
        BST.inorder();
    }
}

