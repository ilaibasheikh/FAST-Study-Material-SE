import javax.swing.*;
import java.awt.*;

public class IndeterminateProgressBarExample extends JFrame {

    public IndeterminateProgressBarExample() {
        setTitle("Indeterminate JProgressBar Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create an indeterminate JProgressBar
        JProgressBar indeterminateProgressBar = new JProgressBar();
        indeterminateProgressBar.setIndeterminate(true); // Set to indeterminate mode

        // Add the JProgressBar to the frame
        add(indeterminateProgressBar);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new IndeterminateProgressBarExample();
    }
}
