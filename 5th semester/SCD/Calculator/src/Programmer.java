import javax.swing.*;

public class Programmer extends JFrame{
    private JPanel Programmer;
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
    private JTextArea a0000000000000000TextArea;
    private JButton aButton;
    private JButton modButton;
    private JRadioButton hexRadioButton;
    private JRadioButton binRadioButton;
    private JRadioButton qwordRadioButton;
    private JRadioButton wordRadioButton;
    private JRadioButton decRadioButton;
    private JRadioButton octRadioButton;
    private JRadioButton dwordRadioButton;
    private JRadioButton byteRadioButton;

    public Programmer(Calculator cal){
        JMenuBar menuBar = cal.createMenu();
        setJMenuBar(menuBar);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\Hp\\Desktop\\5 semester\\SCD\\Calculator\\src\\WhatsApp Image 2024-09-28 at 12.21.51_bd9d5d60.jpg");
        setIconImage(logoIcon.getImage());
        setContentPane(Programmer);
        a0TextField.setText("0");
        pack();
        setVisible(true);

        ButtonGroup converGroup = new ButtonGroup();
        converGroup.add(hexRadioButton);
        converGroup.add(binRadioButton);
        converGroup.add(decRadioButton);
        converGroup.add(octRadioButton);
        decRadioButton.setSelected(true);

        ButtonGroup wordGroup = new ButtonGroup();
        wordGroup.add(qwordRadioButton);
        wordGroup.add(wordRadioButton);
        wordGroup.add(dwordRadioButton);
        wordGroup.add(byteRadioButton);
        qwordRadioButton.setSelected(true);
    }


}
