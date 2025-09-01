import javax.swing.*;
import java.awt.event.*;

public class ComponentShownExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Component Shown Example");
        JButton button = new JButton("Show Me");

        button.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                System.out.println("Component shown: " + e.getComponent());
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Hide and show the button after 2 seconds
        new Timer(2000, e -> {
            button.setVisible(false);
            new Timer(1000, ev -> button.setVisible(true)).start();
        }).start();
    }
}
