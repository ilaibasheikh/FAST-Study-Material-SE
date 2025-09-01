public class Q5 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node next;

        public Node(int data) {
            this.data = data;
            next=null;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    public void mergeTrees(Node root1, Node root2) {
        // stack for tree 1
        Stack s1 = new Stack();
        Node current1 = root1;

        //stack for tree 2
        Stack s2 = new Stack();
        Node current2 = root2;

        while (current1 != null || current2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            while (current1 != null) {
                s1.push(current1);
                current1 = current1.left;
            }

            while (current2 != null) {
                s2.push(current2);
                current2 = current2.left;
            }

            if (!s1.isEmpty() && !s2.isEmpty()) {
                current1 = s1.pop();
                current2 = s2.pop();

                if (current1.data < current2.data) {
                    System.out.print(current1.data + " ");
                    current1 = current1.right;
                    s2.push(current2);
                    current2 = null;
                } else {
                    System.out.print(current2.data + " ");
                    current2 = current2.right;
                    s1.push(current1);
                    current1 = null;
                }
            } else if (!s1.isEmpty()) {
                current1 = s1.pop();
                System.out.print(current1.data + " ");
                current1 = current1.right;
            } else if (!s2.isEmpty()) {
                current2 = s2.pop();
                System.out.print(current2.data + " ");
                current2 = current2.right;
            }
        }
    }
    public class Stack {
        Node root;
        public boolean isEmpty() {
            return root == null;
        }
        public void push(Node data) {
            Node newNode = new Node(data.data);
            newNode.left = data.left;
            newNode.right = data.right;
            newNode.next = root;
            root = newNode;
        }
        public Node pop() {
            if (isEmpty()) {
                return null;
            }
            Node temp = root;
            root = root.next;
            temp.next = null;
            return temp;
        }
    }
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        // 1st binary tree
        Q5 tree1 = new Q5();
        tree1.root = new Node(5);
        tree1.root.left = new Node(3);
        tree1.root.right = new Node(6);
        tree1.root.left.left = new Node(2);
        tree1.root.left.right = new Node(4);

        // 2nd binary tree
        Q5 tree2 = new Q5();
        tree2.root = new Node(2);
        tree2.root.left = new Node(1);
        tree2.root.right = new Node(3);
        tree2.root.right.right = new Node(7);
        tree2.root.right.right.left = new Node(6);

        System.out.println("Merged Binary Tree:");
        Q5 newTree = new Q5();
        newTree.mergeTrees(tree1.root, tree2.root);
    }
}
