import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class VerticalJSliderExample extends JFrame {

    public VerticalJSliderExample() {
        setTitle("Vertical JSlider Example");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a vertical JSlider
        JSlider verticalSlider = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        verticalSlider.setMajorTickSpacing(20);
        verticalSlider.setMinorTickSpacing(5);
        verticalSlider.setPaintTicks(true);
        verticalSlider.setPaintLabels(true);

        // Custom labels
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("Min"));
        labelTable.put(50, new JLabel("Mid"));
        labelTable.put(100, new JLabel("Max"));
        verticalSlider.setLabelTable(labelTable);

        // Add a ChangeListener to handle slider value changes
        verticalSlider.addChangeListener(e -> {
            int value = verticalSlider.getValue();
            System.out.println("Slider value: " + value);
        });

        // Add the JSlider to the frame
        add(verticalSlider);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new VerticalJSliderExample();
    }
}
