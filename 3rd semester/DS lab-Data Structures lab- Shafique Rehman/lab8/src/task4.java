import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class task4 {
    Node root;
     task4() {
        root = null;
    }

     void insert(int value) {
        root = insertVal(root, value);
    }
     Node insertVal(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insertVal(root.left, value);
        } else if (value > root.data) {
            root.right = insertVal(root.right, value);
        }

        return root;
    }

     void findClosestValue(int x, String operation) {
        List<Integer> closestValues = new ArrayList<>();
        findClosestValue(root, x, operation, closestValues);
        if (closestValues.isEmpty()) {
            System.out.println("No closest value found.");
        } else {
            System.out.println("Closest value(s): " + closestValues);
        }
    }

     void findClosestValue(Node root, int x, String operation, List<Integer> closestValues) {
        if (root == null) {
            return;
        }
        if (operation.equalsIgnoreCase("ceil")) {
            if (root.data == x + 1) {
                closestValues.add(root.data);
            } else if (root.data > x + 1) {
                closestValues.add(root.data);
                findClosestValue(root.left, x, operation, closestValues);
            } else {
                findClosestValue(root.right, x, operation, closestValues);
            }
        } else if (operation.equalsIgnoreCase("floor")) {
            if (root.data == x - 1) {
                closestValues.add(root.data);
            } else if (root.data < x - 1) {
                closestValues.add(root.data);
                findClosestValue(root.right, x, operation, closestValues);
            } else {
                findClosestValue(root.left, x, operation, closestValues);
            }
        }
    }
        void inorderVisit(Node root) {
        if (root != null) {
            inorderVisit(root.left);
            System.out.print(root.data + " -> ");
            inorderVisit(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        task4 tree = new task4();

        int[] data = {10, 5, 11, 4, 7, 8};
        for (int i : data) {
            tree.insert(i);
        }
        System.out.println("This is the binary tree : ");
        tree.inorderVisit(tree.root);
        System.out.println();


        System.out.print("Enter the value X: ");
        int x = a.nextInt();
        a.nextLine();

        System.out.print("Enter 'ceil' or 'floor': ");
        String choice = a.nextLine();

        if (choice.equalsIgnoreCase("ceil")) {
            x = x + 1;
        } else if (choice.equalsIgnoreCase("floor")) {
            x = x - 1;
        }


        tree.findClosestValue(x, choice);

    }

}

