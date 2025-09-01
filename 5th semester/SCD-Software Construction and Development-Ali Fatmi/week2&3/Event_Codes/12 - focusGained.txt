import javax.swing.*;
import java.awt.event.*;

public class FocusGainedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Focus Gained Example");
        JTextField textField = new JTextField(20);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Focus gained: " + e.getComponent());
            }
        });

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
