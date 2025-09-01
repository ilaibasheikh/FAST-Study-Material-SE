import javax.swing.*;
import java.awt.event.*;

public class WindowActivatedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Activated Example");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Window activated: " + e.getWindow());
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
