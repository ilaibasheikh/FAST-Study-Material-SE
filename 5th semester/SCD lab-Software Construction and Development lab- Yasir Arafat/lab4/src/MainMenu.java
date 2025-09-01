import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JPanel mainmenu;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JButton logOutButton;
    private JTextField textField2;
    private JButton depositButton;
    private JTextField textField3;
    private JButton withdrawButton;

    String balance = "20000";

    public MainMenu() {
        setContentPane(mainmenu);
        setTitle("Main Menu:");
        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField1.setEditable(false);
        textField1.setText(balance);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value1 = Integer.parseInt(textField1.getText());

                int value2 = Integer.parseInt(textField2.getText());

                if(value2 >0){
                    int value3= value1 + value2;
                    textField1.setText(String.valueOf(value3));
                    JOptionPane.showMessageDialog(depositButton, "Check Your Balance!", "Deposit Successsful!", JOptionPane.INFORMATION_MESSAGE);
                    textField2.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(depositButton,"Input should be positive", "Invalid Input",JOptionPane.ERROR_MESSAGE);
                    textField2.setText("");
                }
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value1 = Integer.parseInt(textField1.getText());

                int value2 = Integer.parseInt(textField3.getText());

                if((value2 >0) && (value1 >value2)){
                    int value3= value1 - value2;
                    textField1.setText(String.valueOf(value3));
                    JOptionPane.showMessageDialog(withdrawButton, "Check Your Balance!", "Withdraw Successful!", JOptionPane.INFORMATION_MESSAGE);
                    textField3.setText("");
                }
                if(value2 <0){
                    JOptionPane.showMessageDialog(withdrawButton,"Input should be positive", "Invalid Input",JOptionPane.ERROR_MESSAGE);
                    textField3.setText("");
                }
                if(value1 <value2){
                    JOptionPane.showMessageDialog(withdrawButton,"Insufficient Funds", "Withdraw Unsuccessful!",JOptionPane.ERROR_MESSAGE);
                    textField3.setText("");
                }

            }
        });
    }
}
