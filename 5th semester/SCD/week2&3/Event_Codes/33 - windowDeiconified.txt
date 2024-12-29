import javax.swing.*;
import java.awt.event.*;

public class WindowDeiconifiedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Deiconified Example");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window deiconified: " + e.getWindow());
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
