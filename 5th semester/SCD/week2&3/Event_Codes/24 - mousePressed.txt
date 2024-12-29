import javax.swing.*;
import java.awt.event.*;

public class MousePressedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Pressed Example");
        JButton button = new JButton("Press Me");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse pressed at: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
