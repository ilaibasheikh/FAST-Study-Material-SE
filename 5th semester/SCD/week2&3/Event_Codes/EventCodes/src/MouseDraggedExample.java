import javax.swing.*;
import java.awt.event.*;

public class MouseDraggedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Dragged Example");
        JLabel label = new JLabel("Drag Me");

        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Mouse dragged to: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
