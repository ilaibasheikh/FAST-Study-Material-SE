import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task4 extends JFrame {
    private JPanel calculator;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton calculateSGPAButton;
    private JButton resetButton;


public task4() {
    setContentPane(calculator);
    setTitle("SGPA Calculator");
    setSize(300,300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    calculateSGPAButton.addActionListener(new ActionListener() {



        @Override
        public void actionPerformed(ActionEvent e) {
            if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() ||
                    textField4.getText().isEmpty() || textField5.getText().isEmpty() || textField6.getText().isEmpty() ||
                    textField7.getText().isEmpty() || textField8.getText().isEmpty() || textField9.getText().isEmpty() ||
                    textField10.getText().isEmpty() || textField11.getText().isEmpty() || textField12.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled out.");

            } else {
                double sgpa = 0;
                try {
                    int totalCreditHours = Integer.parseInt(textField6.getText()) + Integer.parseInt(textField9.getText()) +
                            Integer.parseInt(textField12.getText());
                    double totalPoints = (Double.parseDouble((textField5.getText())) * Integer.parseInt((textField6.getText()))) +
                            (Double.parseDouble((textField8.getText())) * Integer.parseInt((textField9.getText()))) +
                            (Double.parseDouble((textField11.getText())) * Integer.parseInt((textField12.getText())));
                    sgpa = totalPoints / totalCreditHours;


                    if (totalCreditHours == 0) {
                        throw new ArithmeticException();
                    }


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for grades and credit" +
                            " hours.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Total credit hours cannot be zero.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                new sgpaform(textField4.getText(), Double.parseDouble((textField5.getText())), Integer.parseInt((textField6.getText())),
                        textField7.getText(), Double.parseDouble((textField8.getText())), Integer.parseInt((textField9.getText())),
                        textField10.getText(), Double.parseDouble((textField11.getText())), Integer.parseInt((textField12.getText())),
                        String.format("%.2f", sgpa));


            }
        }
    });
    resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            textField7.setText("");
            textField8.setText("");
            textField9.setText("");
            textField10.setText("");
            textField11.setText("");
            textField12.setText("");
        }
    });
}

    public static void main(String[] args) {
task4 f = new task4();
    }
}
