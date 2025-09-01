import javax.swing.*;
import java.awt.event.*;

public class WindowOpenedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Opened Example");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened: " + e.getWindow());
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
