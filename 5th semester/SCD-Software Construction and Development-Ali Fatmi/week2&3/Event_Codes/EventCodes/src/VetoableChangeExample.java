import javax.swing.*;
import java.beans.*;

public class VetoableChangeExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Vetoable Change Example");
        JButton button = new JButton("Click Me");

        button.addVetoableChangeListener(new VetoableChangeListener() {
            @Override
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                if ("text".equals(evt.getPropertyName())) {
                    String newValue = (String) evt.getNewValue();
                    if (newValue.contains("Veto")) {
                        throw new PropertyVetoException("Change vetoed", evt);
                    }
                }
            }
        });

        button.setText("Click Me Veto"); // This will trigger the vetoableChange event

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
