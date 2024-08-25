public class Q3 {
    class Node{
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
    Node insert(Node node, int data) {

        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right,data);

        return node;
    }
    Node search(Node root, int key,int count) {
        if (root == null){
            return null;}
        if(root.data == key){
            System.out.println("key = "+key+" found at level "+count);
            return root;
        }
        if (root.data< key){
            return search(root.right, key,count+1);
        }else {
            return search(root.left, key,count+1);
        }
    }
    public static void main(String[] args) {
        Q3 tree =new Q3();
        tree.root = tree.insert(tree.root, 24);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 34);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 9);
        tree.insert(tree.root, 100);

        int key = 17;
        // Searching in tree
        if (tree.search(tree.root, key,0) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
        key = 100;

        // Searching in tree
        if (tree.search(tree.root, key,0) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
    }
}

