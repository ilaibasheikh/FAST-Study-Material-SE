import javax.swing.*;
import java.awt.event.*;

public class WindowDeactivatedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Deactivated Example");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window deactivated: " + e.getWindow());
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
