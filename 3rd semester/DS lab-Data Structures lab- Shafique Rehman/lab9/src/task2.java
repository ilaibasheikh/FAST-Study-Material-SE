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
//
//public class task2
//{
//    Node root;
//
//    int height(Node N)
//    {
//        if (N == null)
//            return 0;
//        return N.height;
//    }
//
//    int max(int a, int b)
//    {
//        return (a > b) ? a : b;
//    }
//
//    Node rightRotate(Node y)
//    {
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
//    Node leftRotate(Node x)
//    {
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
//    int getBalance(Node N)
//    {
//        if (N == null)
//            return 0;
//        return height(N.left) - height(N.right);
//    }
//
//    Node insert(Node node, int data)
//    {
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
//        if (balance > 1 && data > node.left.data)
//        {
//            node.left = leftRotate(node.left);
//            return rightRotate(node);
//        }
//
//
//        if (balance < -1 && data < node.right.data)
//        {
//            node.right = rightRotate(node.right);
//            return leftRotate(node);
//        }
//
//        return node;
//    }
//
//
//    Node minValueNode(Node min)
//    {
//        Node current = min;
//
//
//        while (current.left != null)
//            current = current.left;
//
//        return current;
//    }
//
//    Node deleteNode(Node root, int data)
//    {
//
//        if (root == null)
//            return root;
//
//
//        if (data < root.data)
//            root.left = deleteNode(root.left, data);
//
//
//        else if (data > root.data)
//            root.right = deleteNode(root.right, data);
//
//
//        else
//        {
//
//            if ((root.left == null) || (root.right == null))
//            {
//                Node temp = null;
//                if (temp == root.left)
//                    temp = root.right;
//                else
//                    temp = root.left;
//
//
//                if (temp == null)
//                {
//                    temp = root;
//                    root = null;
//                }
//                else
//                    root = temp;
//
//            }
//            else
//            {
//
//                Node temp = minValueNode(root.right);
//
//
//                root.data = temp.data;
//
//                root.right = deleteNode(root.right, temp.data);
//            }
//        }
//
//
//        if (root == null)
//            return root;
//
//
//        root.height = max(height(root.left), height(root.right)) + 1;
//
//
//        int balance = getBalance(root);
//
//
//        if (balance > 1 && getBalance(root.left) >= 0)
//            return rightRotate(root);
//
//        if (balance > 1 && getBalance(root.left) < 0)
//        {
//            root.left = leftRotate(root.left);
//            return rightRotate(root);
//        }
//
//
//        if (balance < -1 && getBalance(root.right) <= 0)
//            return leftRotate(root);
//
//
//        if (balance < -1 && getBalance(root.right) > 0)
//        {
//            root.right = rightRotate(root.right);
//            return leftRotate(root);
//        }
//
//        return root;
//    }
//
//    void preOrder(Node node)
//    {
//        if (node != null)
//        {
//            System.out.print(node.data + " ");
//            preOrder(node.left);
//            preOrder(node.right);
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        task2 tree = new task2();
//
//        tree.root = tree.insert(tree.root, 1);
//        tree.root = tree.insert(tree.root, 2);
//        tree.root = tree.insert(tree.root, 3);
//        tree.root = tree.insert(tree.root, 4);
//        tree.root = tree.insert(tree.root, 5);
//        tree.root = tree.insert(tree.root, 6);
//        tree.root = tree.insert(tree.root, 7);
//
//            System.out.println("This is the AVL Tree in preorder traversal before deleting 3");
//            tree.preOrder(tree.root);
//
//        tree.root = tree.deleteNode(tree.root, 3);
//
//        System.out.println("");
//        System.out.println("This is the AVL Tree in preorder traversal after deleting 3");
//        tree.preOrder(tree.root);
//    }
//}
//
//
