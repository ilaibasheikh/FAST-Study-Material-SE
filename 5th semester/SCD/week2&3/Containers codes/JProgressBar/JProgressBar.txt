import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class JProgressBarExample extends JFrame {

    private JProgressBar progressBar;
    private Timer timer;

    public JProgressBarExample() {
        setTitle("JProgressBar Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JProgressBar
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true); // Show progress as text
        progressBar.setBorderPainted(true); // Paint border

        // Create a JButton to start the progress
        JButton startButton = new JButton("Start Progress");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProgress();
            }
        });

        // Add components to the frame
        add(progressBar, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    private void startProgress() {
        // Create a Timer to update the progress bar
        timer = new Timer(100, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (value < 100) {
                    value += 1;
                    progressBar.setValue(value);
                    progressBar.setString("Progress: " + value + "%");
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new JProgressBarExample();
    }
}
