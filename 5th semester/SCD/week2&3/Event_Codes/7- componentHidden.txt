import javax.swing.*;
import java.awt.event.*;

public class ComponentHiddenExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Component Hidden Example");
        JButton button = new JButton("Hide Me");

        button.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                System.out.println("Component hidden: " + e.getComponent());
            }
        });

        button.addActionListener(e -> button.setVisible(false));

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
