import javax.swing.*;


public class JSliderExample extends JFrame {

    public JSliderExample() {
        setTitle("JSlider Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create a JSlider with default values
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(10); // Spacing for major ticks
        slider.setMinorTickSpacing(1);  // Spacing for minor ticks
        slider.setPaintTicks(true);     // Show ticks
        slider.setPaintLabels(true);    // Show labels
        slider.setPreferredSize(new java.awt.Dimension(250, 50)); // Set preferred size

        // Create a JLabel to display the slider value
        JLabel valueLabel = new JLabel("Value: " + slider.getValue());

        // Update the JLabel when the slider value changes
        slider.addChangeListener(e -> valueLabel.setText("Value: " + slider.getValue()));

        // Add components to the frame
        add(slider);
        add(valueLabel);

        // Pack and center the frame
        pack();
        setLocationRelativeTo(null); // Center the frame

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JSliderExample::new); // Use invokeLater for thread safety
    }
}
