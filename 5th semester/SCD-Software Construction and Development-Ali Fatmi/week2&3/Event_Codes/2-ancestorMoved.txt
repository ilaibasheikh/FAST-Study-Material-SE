import javax.swing.*;
import javax.swing.event.*;

public class AncestorMovedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ancestor Moved Example");
        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");

        button.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                // Not used in this example
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                // Not used in this example
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                System.out.println("Ancestor moved.");
            }
        });

        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        // Move the frame after 2 seconds
        new Timer(2000, e -> frame.setLocation(200, 200)).start();
    }
}
