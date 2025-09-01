import javax.swing.*;
import javax.swing.event.*;

public class AncestorRemovedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ancestor Removed Example");
        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");

        button.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                // Not used in this example
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                System.out.println("Component removed from the hierarchy.");
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
        
        // Remove the button after 2 seconds
        new Timer(2000, e -> panel.remove(button)).start();
    }
}
