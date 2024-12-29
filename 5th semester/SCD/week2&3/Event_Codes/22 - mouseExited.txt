import javax.swing.*;
import java.awt.event.*;

public class MouseExitedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Exited Example");
        JButton button = new JButton("Hover Over Me");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse exited the button.");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
