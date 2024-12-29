import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task3 extends JFrame{
    private JPanel login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signInButton;
    String username = "22k-5195";
    String password = "a";



    public task3() {
        setContentPane(login);
        setTitle("ATM machine");
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if ((textField1.getText().equals(username)) && passwordField1.getText().equals(password)){
                   dispose();
                   new MainMenu();
                }
               else{
                   JOptionPane.showMessageDialog(signInButton,"Invalid username or pin", "Login Failed!",JOptionPane.ERROR_MESSAGE);
               }

            }
        });
    }

    public static void main(String[] args) {
        task3 f1 = new task3();

    }
}
