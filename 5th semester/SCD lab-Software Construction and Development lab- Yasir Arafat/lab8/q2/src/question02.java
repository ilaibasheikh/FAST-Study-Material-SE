import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class question02 extends JFrame{
    private JButton createAccountButton;
    private JButton manageUsersButton;
    private JPanel panel;

    public question02() {
        setContentPane(panel);
        setTitle("Home Page");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new create();
            }
        });
        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
new manage();
            }
        });
    }

    public static void main(String[] args) {
new question02();
    }

}
