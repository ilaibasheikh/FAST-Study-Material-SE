import javax.swing.*;
import java.awt.event.*;

public class MouseClickedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Clicked Example");
        JButton button = new JButton("Click Me");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
