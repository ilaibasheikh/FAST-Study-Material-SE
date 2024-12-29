import javax.swing.*;
import java.awt.event.*;

public class ComponentRemovedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Component Removed Example");
        JPanel panel = new JPanel();

        panel.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                // Not used in this example
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                System.out.println("Component removed: " + e.getChild());
            }
        });

        JButton addButton = new JButton("Add Label");
        JButton removeButton = new JButton("Remove Label");

        JLabel label = new JLabel("Removable Label");

        addButton.addActionListener(e -> panel.add(label));
        removeButton.addActionListener(e -> panel.remove(label));

        panel.add(addButton);
        panel.add(removeButton);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
