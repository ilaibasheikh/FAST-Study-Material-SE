import javax.swing.*;
import java.awt.event.*;

public class MouseReleasedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Released Example");
        JButton button = new JButton("Release Me");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released at: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
