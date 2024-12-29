import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSpinnerExample extends JFrame {

    public JSpinnerExample() {
        setTitle("JSpinner Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a JSpinner with numeric model
        SpinnerNumberModel numberModel = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner spinner = new JSpinner(numberModel);

        // Create a JButton to retrieve the value
        JButton getValueButton = new JButton("Get Value");
        getValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = (int) spinner.getValue();
                JOptionPane.showMessageDialog(null, "Selected value: " + value);
            }
        });

        // Add components to the frame
        add(new JLabel("Select a number:"));
        add(spinner);
        add(getValueButton);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JSpinnerExample();
    }
}
