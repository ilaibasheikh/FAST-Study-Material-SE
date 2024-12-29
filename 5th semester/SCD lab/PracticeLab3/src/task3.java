import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task3 extends JFrame {
    private JTextField textField1;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JButton submitFeedbackButton;
    private JPanel task3;

    public task3() {
        setContentPane(task3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300,300);
        submitFeedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String feedback = textArea1.getText();
                String rating =(String) comboBox1.getSelectedItem();
                JOptionPane.showMessageDialog(submitFeedbackButton, "Thankyou, "+name +"\nYour Rating: " + rating+"\nYour Feedback: " + feedback  );
            }
        });
    }

    public static void main(String[] args) {
        new task3();
    }
}
