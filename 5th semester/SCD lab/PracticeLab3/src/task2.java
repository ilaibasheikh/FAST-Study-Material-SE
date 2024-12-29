import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task2 extends JFrame {
    private JTextField textField1;
    private JButton searchButton;
    private JTextArea textArea1;
    private JPanel task2;

    public task2() {
        setContentPane(task2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Library Book Search");
        setSize(300,300);
        setVisible(true);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = textField1.getText();
                textArea1.setText("3 books found matching '" + search+"'");

            }
        });
    }

    public static void main(String[] args) {
        new task2();
    }
}
