import javax.swing.*;
import java.awt.event.*;

public class ComponentAddedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Component Added Example");
        JPanel panel = new JPanel();
        
        panel.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println("Component added: " + e.getChild());
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                // Not used in this example
            }
        });

        JButton button = new JButton("Add Label");
        button.addActionListener(e -> panel.add(new JLabel("New Label")));

        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
