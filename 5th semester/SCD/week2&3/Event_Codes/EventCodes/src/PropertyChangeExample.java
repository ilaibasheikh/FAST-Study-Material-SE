import javax.swing.*;
import java.beans.*;

public class PropertyChangeExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Property Change Example");
        JButton button = new JButton("Click Me");

        button.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Property changed: " + evt.getPropertyName() +
                                   ", Old value: " + evt.getOldValue() +
                                   ", New value: " + evt.getNewValue());
            }
        });

        button.setText("New Text"); // This will trigger the propertyChange event

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
