import javax.swing.*;

public class Mortgage extends JFrame {
    private JPanel Mortgage;
    private JPanel StandardCalc;
    private JTextField a0TextField;
    private JButton MCButton;
    private JButton MRButton;
    private JButton MSButton;
    private JButton mButton;
    private JButton mButton1;
    private JButton button1;
    private JButton CEButton;
    private JButton cButton;
    private JButton button4;
    private JButton button5;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button7;
    private JButton button8;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button9;
    private JButton a1Button;
    private JButton a1Button1;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button10;
    private JButton a0Button;
    private JButton button2;
    private JButton button3;
    private JButton button6;
    private JButton calculateButton;

    public Mortgage(Calculator cal){
        JMenuBar menuBar = cal.createMenu();
        setJMenuBar(menuBar);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\Hp\\Desktop\\5 semester\\SCD\\Calculator\\src\\WhatsApp Image 2024-09-28 at 12.21.51_bd9d5d60.jpg");
        setIconImage(logoIcon.getImage());
        setContentPane(Mortgage);
        a0TextField.setText("0");
        pack();
        setVisible(true);
    }
}
