import javax.swing.*;
import java.awt.event.*;

public class KeyTypedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Typed Example");
        JTextField textField = new JTextField(20);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key typed: " + e.getKeyChar());
            }
        });

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
