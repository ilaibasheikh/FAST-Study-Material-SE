import javax.swing.*;
import javax.swing.event.*;

public class AncestorAddedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ancestor Added Example");
        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");

        button.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                System.out.println("Component added to the hierarchy.");
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                // Not used in this example
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                // Not used in this example
            }
        });

        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
