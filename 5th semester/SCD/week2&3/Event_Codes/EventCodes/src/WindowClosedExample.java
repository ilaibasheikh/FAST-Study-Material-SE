import javax.swing.*;
import java.awt.event.*;

public class WindowClosedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Closed Example");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window closed: " + e.getWindow());
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
