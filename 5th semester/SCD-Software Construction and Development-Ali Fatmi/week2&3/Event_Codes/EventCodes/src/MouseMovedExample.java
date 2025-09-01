import javax.swing.*;
import java.awt.event.*;

public class MouseMovedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Moved Example");
        JLabel label = new JLabel("Move the mouse over me");

        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("Mouse moved to: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
