import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class create extends JFrame{
    private JTextField id;
    private JTextField mail;
    private JTextField name;
    private JPasswordField pass;
    private JPasswordField conf;
    private JButton submitButton;
    private JTextField dob;
    private JPanel panel;


    public create() {
        setContentPane(panel);
        setTitle("Registration Form");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

int u_id = Integer.parseInt(id.getText());
String email = mail.getText();
String u_name= name.getText();

String password = pass.getText();
String dobb = dob.getText();


                    String sql = "INSERT INTO adminusers (u_id ,email, u_name,password , dob) VALUES (? , ? , ? , ?  , ? )";
                    try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement =
                            connection.prepareStatement(sql)) {
                        preparedStatement.setInt(1, u_id);
                        preparedStatement.setString(3, email);
                        preparedStatement.setString(2, u_name);
                        preparedStatement.setString(4, password);
                        preparedStatement.setString(5, dobb);

                        int rowsAffected = preparedStatement.executeUpdate();  System.out.println(rowsAffected + " row(s) inserted.");  } catch (
                            SQLException x) {
                        System.out.println("Connection or insert failed!");  x.printStackTrace();
                    }

            }
        });
    }



}
