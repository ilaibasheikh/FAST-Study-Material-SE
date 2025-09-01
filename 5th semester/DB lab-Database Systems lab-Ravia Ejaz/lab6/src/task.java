import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class task extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton submitButton;
    private JButton viewTableButton;
    private JPanel Form;
    String url= "jdbc:mysql://localhost:3306/lab6";
    String username="rootLaiba";
    String password="laiba5195";

    public task() {
        setContentPane(Form);
        setTitle("Books by Laiba Fatima 22k-5195");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert(textField1.getText(), textField2.getText(), textField3.getText());
            }
        });
        viewTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });
    }

    public void insert(String isbn, String title, String author){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Database connection successful");
            String query = "INSERT INTO Books (ISBN_NO, Title, Author) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,isbn);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book added successfully!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }
    public void view(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Database connection successful");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Books");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+ " " + resultSet.getString(2)
                        + " " +resultSet.getString(3));
            }
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }


    public static void main(String[] args) {

new task();


    }
}
