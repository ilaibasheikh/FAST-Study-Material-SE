import javax.swing.*;
import java.awt.event.*;

public class HierarchyChangedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hierarchy Changed Example");
        JPanel panel = new JPanel();
        JButton button = new JButton("Add Label");

        panel.addHierarchyListener(new HierarchyListener() {
            @Override
            public void hierarchyChanged(HierarchyEvent e) {
                System.out.println("Hierarchy changed: " + e.getChanged());
            }
        });

        button.addActionListener(e -> panel.add(new JLabel("New Label")));

        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
