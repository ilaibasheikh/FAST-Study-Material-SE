import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class task6 extends JFrame{
    private JPanel LOGIN;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton signInButton;
    String username = "22k-5195";
    String password = "a";


public task6() {
    signInButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if((textField1.getText().equals(username)) && (passwordField1.getText().equals(password))){
                dispose();
                register f2 = new register();
                f2.setContentPane(f2.Dashboard);
                f2.setTitle("FlexStudents");
                f2.setSize(300,300);
                f2.setVisible(true);


            }
            else{
                JOptionPane.showMessageDialog(signInButton, "Username or password invalid! ");
            }

        }
    });
}

    public static void main(String[] args) {
        task6 f1 = new task6();
        f1.setContentPane(f1.LOGIN);
        f1.setTitle("FlexStudents");
        f1.setSize(300,300);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
