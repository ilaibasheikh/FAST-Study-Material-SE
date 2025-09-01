import javax.swing.*;
import java.awt.*;

public class MyLayeredPaneExample extends JFrame {

    public MyLayeredPaneExample() {
        // Set the title of the JFrame
        setTitle("JLayeredPane Example");

        // Set the size of the JFrame
        setSize(400, 300);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

        // Create a JLabel at the default (lowest) layer
        JLabel label1 = new JLabel("Label 1 - Background");
        label1.setOpaque(true);
        label1.setBackground(Color.CYAN);
        label1.setBounds(50, 50, 150, 100);
        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);

        // Create another JLabel at the default (lowest) layer, overlapping the first
        JLabel label2 = new JLabel("Label 2 - Middleground");
        label2.setOpaque(true);
        label2.setBackground(Color.ORANGE);
        label2.setBounds(100, 100, 150, 100);
        layeredPane.add(label2, JLayeredPane.PALETTE_LAYER);

        // Create a third JLabel in a higher layer, overlapping both
        JLabel label3 = new JLabel("Label 3 - Foreground");
        label3.setOpaque(true);
        label3.setBackground(Color.PINK);
        label3.setBounds(150, 150, 150, 100);
        layeredPane.add(label3, JLayeredPane.DRAG_LAYER);

        // Add the JLayeredPane to the JFrame
        add(layeredPane);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of MyLayeredPaneExample
        new MyLayeredPaneExample();
    }
}
