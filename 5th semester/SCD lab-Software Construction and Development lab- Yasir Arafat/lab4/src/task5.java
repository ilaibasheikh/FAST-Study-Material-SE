import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class task5 extends JFrame {
    private JTextField textField1;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JButton transformButton;
    private JPanel transform;
    private JTextField textField2;

    public task5() {
        textArea1.setEditable(false);
        transformButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem().equals("Uppercase")) {
                    textArea1.setText(textField1.getText().toUpperCase());
                } else if (comboBox1.getSelectedItem().equals("Reverse")) {
                    StringBuilder input1 = new StringBuilder();
                    input1.append(textField1.getText());
                    textArea1.setText(String.valueOf(input1.reverse()));
                } else {
                    textArea1.setText(textField1.getText().replaceAll(" ", "_"));
                }
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                textField1.setText(textField2.getText());
                textField1.setEditable(false);
            }
        });
    }

    public static void main(String[] args) {
        task5 fr = new task5();
        fr.setContentPane(fr.transform);
        fr.setTitle("Real-Time ");
        fr.setSize(300,300);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
