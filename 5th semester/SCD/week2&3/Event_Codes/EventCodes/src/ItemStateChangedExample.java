import javax.swing.*;
import java.awt.event.*;

public class ItemStateChangedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Item State Changed Example");
        JCheckBox checkBox = new JCheckBox("Check Me");

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Checkbox selected");
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    System.out.println("Checkbox deselected");
                }
            }
        });

        frame.add(checkBox);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
