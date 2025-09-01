import javax.swing.*;
import java.awt.event.*;

public class KeyPressedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Pressed Example");
        JTextField textField = new JTextField(20);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
