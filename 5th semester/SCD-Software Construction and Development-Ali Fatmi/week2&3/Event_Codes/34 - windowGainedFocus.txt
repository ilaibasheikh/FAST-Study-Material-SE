import javax.swing.*;
import java.awt.event.*;

public class WindowGainedFocusExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Gained Focus Example");
        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("Window gained focus: " + e.getWindow());
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // Not used in this example
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
