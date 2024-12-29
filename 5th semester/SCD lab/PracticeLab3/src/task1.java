import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task1 extends JFrame  {
    private JTextField textField1;
    private JComboBox comboBox1;
    private JCheckBox debateClubCheckBox;
    private JCheckBox scienceFairCheckBox;
    private JCheckBox sportsCheckBox;
    private JButton registerButton;
    private JPanel task1;

    public task1() {
        setContentPane(task1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Registration Form");
        pack();
        setSize(300,300);
        setVisible(true);



        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String grade = (String) comboBox1.getSelectedItem();
                String debate = debateClubCheckBox.isSelected() ? debateClubCheckBox.getText() : "";
                String science = scienceFairCheckBox.isSelected() ? scienceFairCheckBox.getText() : "";
                String sports = sportsCheckBox.isSelected() ? sportsCheckBox.getText() : "";
                JOptionPane.showMessageDialog(registerButton, "Your name: " +name +"\nGrade: " +grade
                +"\nActivities: " +debate + " "+ science + " "+sports);

            }
        });

    }

    public static void main(String[] args) {
        new task1();
    }
}
