import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task6 extends JFrame{
    private JPanel task6;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton signInButton;
    private JPanel task66;
    String username = "admin";
    String password = "1234";

    public task6() {
        setContentPane(task6);
        setTitle("FlexStudents");
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((textField1.getText().equals(username)) && (passwordField1.getText().equals(password))){
                    dispose();
                    new task6a();
                }
                else{
                    JOptionPane.showMessageDialog(signInButton, "Username or password invalid! ");
                }
            }
        });
    }
    public static void main(String[] args) {
         new task6();
    }
}
