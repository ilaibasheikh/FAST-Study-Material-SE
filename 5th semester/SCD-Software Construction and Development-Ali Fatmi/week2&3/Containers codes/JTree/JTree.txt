import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class JTreeExample extends JFrame {

    public JTreeExample() {
        setTitle("JTree Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // Create child nodes
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Node 1");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Node 2");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Node 3");

        // Add child nodes to the root
        root.add(node1);
        root.add(node2);
        root.add(node3);

        // Create a tree model from the root node
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        // Create a JTree with the tree model
        JTree tree = new JTree(treeModel);

        // Add the JTree to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(tree);

        // Add JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTreeExample::new);
    }
}
