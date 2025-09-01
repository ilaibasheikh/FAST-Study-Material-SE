import javax.swing.*;
import java.awt.event.*;

public class KeyReleasedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Released Example");
        JTextField textField = new JTextField(20);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
