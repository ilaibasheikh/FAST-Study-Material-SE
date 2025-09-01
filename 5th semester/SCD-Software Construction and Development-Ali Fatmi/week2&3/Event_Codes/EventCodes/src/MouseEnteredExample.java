import javax.swing.*;
import java.awt.event.*;

public class MouseEnteredExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Entered Example");
        JButton button = new JButton("Hover Over Me");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered the button.");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
