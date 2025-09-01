import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButtonExample extends JFrame {

    public CustomButtonExample() {
        setTitle("Custom JButton Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create buttons with different actions
        JButton button1 = new JButton("Show Message");
        JButton button2 = new JButton("Change Color");
        JButton button3 = new JButton("Exit");

        // ActionListener for button1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You clicked Show Message!");
            }
        });

        // ActionListener for button2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.GREEN);
            }
        });

        // ActionListener for button3
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add buttons to the frame
        add(button1);
        add(button2);
        add(button3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomButtonExample();
    }
}
