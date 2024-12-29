import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class manage extends JFrame{
    private JTextField mm;
    private JPasswordField pp;
    private JButton log;
    private JPanel panel;


    public manage() {
        setContentPane(panel);
        setTitle("Registration Form");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = mm.getText();
                if(mail.equals("superadmin@gmail.com")){
                    new superadmin();
                }
                else if (mail.endsWith("@admin.com")) {
new Admin();
                }

            }
        });
    }
}
