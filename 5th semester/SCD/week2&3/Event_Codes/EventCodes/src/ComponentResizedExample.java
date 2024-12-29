import javax.swing.*;
import java.awt.event.*;

public class ComponentResizedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Component Resized Example");
        JButton button = new JButton("Resize Me");

        button.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("Component resized: " + e.getComponent().getSize());
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Resize the frame after 2 seconds
        new Timer(2000, e -> frame.setSize(400, 300)).start();
    }
}
