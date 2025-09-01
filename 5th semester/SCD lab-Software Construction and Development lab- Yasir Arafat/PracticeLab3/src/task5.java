import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task5 extends JFrame {
    private JPanel task5;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JButton placeOrderButton;

    public task5() {
        setContentPane(task5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300,300);
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String order = (String) comboBox1.getSelectedItem();
                String quantity = spinner1.getValue().toString();
                JOptionPane.showMessageDialog(placeOrderButton, name+", you have ordered " + quantity+ " " + order + " " );
            }
        });
    }

    public static void main(String[] args) {
        new task5();
    }
}
