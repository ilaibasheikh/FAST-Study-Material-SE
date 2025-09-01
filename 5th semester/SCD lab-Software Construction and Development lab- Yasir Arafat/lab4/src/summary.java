import javax.swing.*;

public class summary extends  JFrame{
    private JPanel summary;
    private JTextField textField3;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;



    public summary(String course1, double grade1, int creditHours1, String course2, double grade2, int creditHours2,
                   String course3, double grade3, int creditHours3,String value) {
        setContentPane(summary);
        setTitle("Summary Page");
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);
        textField6.setEditable(false);
        textField7.setEditable(false);
        textField8.setEditable(false);
        textField9.setEditable(false);
        textField10.setEditable(false);
        textField11.setEditable(false);



        textField1.setText(course1);
        textField2.setText(String.valueOf(grade1));
        textField3.setText(String.valueOf(creditHours1));
        textField4.setText(course2);
        textField5.setText(String.valueOf(grade2));
        textField6.setText(String.valueOf(creditHours2));
        textField7.setText(course3);
        textField8.setText(String.valueOf(grade3));
        textField9.setText(String.valueOf(creditHours3));
        textField10.setText(String.valueOf(value));
        if (Double.parseDouble(value) == 4) {
            textField11.setText("Excellent");
        } else if (Double.parseDouble(value) > 2 && Double.parseDouble(value) <4 ) {
            textField11.setText("Good");
        }
        else{
            textField11.setText("Needs Improvement");
        }
    }
}
