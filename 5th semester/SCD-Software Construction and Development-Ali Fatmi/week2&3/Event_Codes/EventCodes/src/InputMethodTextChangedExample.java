import javax.swing.*;
import java.awt.event.*;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class InputMethodTextChangedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Input Method Text Changed Example");
        JTextField textField = new JTextField(20);

        textField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent e) {
                System.out.println("Input method text changed.");
            }

            @Override
            public void caretPositionChanged(InputMethodEvent e) {
                // Not used in this example
            }
        });

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
