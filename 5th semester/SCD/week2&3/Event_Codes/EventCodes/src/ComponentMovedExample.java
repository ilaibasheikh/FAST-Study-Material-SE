import javax.swing.*;
import java.awt.event.*;

public class ComponentMovedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Component Moved Example");
        JButton button = new JButton("Move Me");

        button.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                System.out.println("Component moved: " + e.getComponent());
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setLayout(null); // Use absolute positioning

        // Move the button after 2 seconds
        new Timer(2000, e -> button.setLocation(100, 100)).start();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
