import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditableTreeExample extends JFrame {

    public EditableTreeExample() {
        setTitle("Editable JTree Example");
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
        tree.setEditable(true);

        // Create a custom renderer
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
                label.setFont(new Font("Arial", Font.BOLD, 12));
                return label;
            }
        });

        // Add a button to add new nodes
        JButton addButton = new JButton("Add Node");
        addButton.addActionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null) {
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New Node");
                selectedNode.add(newNode);
                treeModel.reload(selectedNode);
                TreePath path = new TreePath(newNode.getPath());
                tree.scrollPathToVisible(path);
                tree.setSelectionPath(path);
            }
        });

        // Add components to the frame
        add(new JScrollPane(tree), BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditableTreeExample::new);
    }
}
