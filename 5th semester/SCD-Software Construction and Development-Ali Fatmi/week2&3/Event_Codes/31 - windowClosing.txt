import javax.swing.*;
import java.awt.event.*;

public class WindowClosingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Closing Example");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing: " + e.getWindow());
                // Perform cleanup or prompt user
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
