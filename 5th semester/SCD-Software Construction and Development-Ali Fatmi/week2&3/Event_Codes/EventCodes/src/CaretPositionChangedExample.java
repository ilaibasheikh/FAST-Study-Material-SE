import javax.swing.*;
import javax.swing.event.*;

public class CaretPositionChangedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Caret Position Changed Example");
        JTextField textField = new JTextField(20);

        textField.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent event) {
                System.out.println("Caret position changed: " + event.getDot());
            }
        });

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
