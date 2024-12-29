import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sgpaform extends JFrame{
    private JTextField textField1;
    private JPanel display;
    private JButton viewSummaryButton;

    public sgpaform(String course1, double grade1, int creditHours1, String course2, double grade2, int creditHours2,
                    String course3, double grade3, int creditHours3,String value){
        setContentPane(display);
        setTitle("Calculated SGPA");
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String str = String.valueOf(value);
       textField1.setText(str);
       textField1.setEditable(false);

        viewSummaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new summary( course1,  grade1,  creditHours1,  course2,  grade2,  creditHours2,
                 course3,  grade3,  creditHours3, value);
            }
        });
    }
}
