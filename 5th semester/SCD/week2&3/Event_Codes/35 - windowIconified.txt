import javax.swing.*;
import java.awt.event.*;

public class WindowIconifiedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Iconified Example");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Window iconified: " + e.getWindow());
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
