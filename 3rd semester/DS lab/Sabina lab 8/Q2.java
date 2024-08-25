public class Q2 {
    class Node{
        int data;
        Node right;
        Node left;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    void insert(int data){
        root=insertRec(root,data);
    }
    public Node insertRec(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        else if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data> root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " -> ");
            inorderRec(root.right);
        }
    }
    void inorder() {
        inorderRec(root);
        System.out.println();
    }
    boolean isFullTree(Node node)
    {
        if(node == null)
            return true;

        if(node.left == null && node.right == null ){
            return true;}

        if((node.left!=null) && (node.right!=null)){
            return (isFullTree(node.left) && isFullTree(node.right));}

        return false;
    }
    public boolean isComplete() {
        return isCompleteRec(root, 0, countNodes(root));
    }
    boolean isCompleteRec(Node root, int index, int nodeCount)
    {
        if (root == null)
            return true;
        if (index >= nodeCount)
            return false;
        return (isCompleteRec(root.left, (index+1)*2, nodeCount)
                && isCompleteRec(root.right,(index+2)*2 , nodeCount));
    }
    int countNodes(Node root)
    {
        if (root == null){
            return 0;}
        else{
        return (1 + countNodes(root.left) + countNodes(root.right));
        }
    }
    public static Node deleteNode(Node root) {
        if (root == null)
            return null;
        if (root.left != null && root.right != null) {
            int leftData = root.left.data;
            int rightData = root.right.data;
            root.left = deleteNode(root.left);
            root.right = deleteNode(root.right);
            return root;
        }
        if (root.left != null) {
            return deleteNode(root.left);
        }
        if (root.right != null) {
            return deleteNode(root.right);
        }
        return null;
    }
    public void completeAndFullTree() {
        while (!isFullTree(root) || !isComplete()) {
            root = deleteNode(root);
        }
    }
    public static void main(String[] args) {
        int[] array={45, 10, 7, 90, 12, 50, 13, 39, 57,6,8,9};
        Q2 BST=new Q2();
        int n= array.length-1;

        for(int i=0;i<n;i++){
            BST.insert( array[i]);
        }
        System.out.println("Original tree:");
        BST.inorder();
        System.out.println();
        if(!BST.isFullTree(BST.root) || !BST.isComplete() ){
            System.out.println("Binary Tree is neither full nor complete");
        }else{
            System.out.println("This is complete and full Binary Tree");
        }

        BST.completeAndFullTree();

        System.out.println();
        System.out.println("Full and Complete Binary Tree:");
        System.out.println();
        if(!BST.isFullTree(BST.root) || !BST.isComplete() ){
            System.out.println("Binary Tree is neither full nor complete");
        }else{
            System.out.println("This is complete and full Binary Tree");
        }
    }
}

