import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task4 extends JFrame {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel task4;
    String username="admin";
    String password="1234";

    public task4() {
        setContentPane(task4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(300,300);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name =textField1.getText();
                String password =passwordField1.getText();
                if(name.equals(username) && password.equals(password)){
                    JOptionPane.showMessageDialog(loginButton,"Welcome "+name);
                }
                else{
                    JOptionPane.showMessageDialog(loginButton,"Wrong password");
                }


            }
        });
    }

    public static void main(String[] args) {
        new task4();
    }
}
