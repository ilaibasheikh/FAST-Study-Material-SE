import javax.swing.*;
import java.awt.event.*;

public class FocusLostExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Focus Lost Example");
        JTextField textField = new JTextField(20);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Focus lost: " + e.getComponent());
            }
        });

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
