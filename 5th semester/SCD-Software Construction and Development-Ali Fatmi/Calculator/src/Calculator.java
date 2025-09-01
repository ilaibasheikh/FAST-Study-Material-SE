import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.*;

public class Calculator extends JFrame {
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

    private double memoryValue = 0.0;
    public void appendToTextField(String value) {
        if (a0TextField.getText().equals("0")) {
            a0TextField.setText(value);
        } else {
            a0TextField.setText(a0TextField.getText() + value);
        }
    }

    private double currentValue = 0.0;
    private String operator = "";
    private boolean operatorPressed = false;

    public void calculate() {
        if (!a0TextField.getText().isEmpty()) {
            double inputValue = Double.parseDouble(a0TextField.getText());
            if (operatorPressed) {
                switch (operator) {
                    case "+":
                        currentValue += inputValue;
                        break;
                    case "-":
                        currentValue -= inputValue;
                        break;
                    case "*":
                        currentValue *= inputValue;
                        break;
                    case "/":
                        if (inputValue != 0) {
                            currentValue /= inputValue;
                        } else {
                            a0TextField.setText("Error");
                            return;
                        }
                        break;
                }
                a0TextField.setText(Double.toString(currentValue));
                operatorPressed = false;
            } else {
                currentValue = inputValue;
            }
        }
    }
    public  JMenuBar createMenu(){

        JMenuBar menuBar = new JMenuBar();

        JMenu viewMenu = new JMenu("View");
        ButtonGroup viewGroup = new ButtonGroup();
        JRadioButtonMenuItem standardView = new JRadioButtonMenuItem("Standard");
        standardView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_DOWN_MASK));
        standardView.setSelected(true);
        standardView.addActionListener(e -> {
            dispose();
            new Calculator();
        });
        JRadioButtonMenuItem scientificView = new JRadioButtonMenuItem("Scientific");
        scientificView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_DOWN_MASK));
        scientificView.addActionListener(e -> {
           dispose();
           Calculator cal = new Calculator();
            new ScientificCalc( cal);
        });
        JRadioButtonMenuItem programmerView = new JRadioButtonMenuItem("Programmer");
        programmerView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_DOWN_MASK));
        programmerView.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new Programmer(cal);
        });
        JRadioButtonMenuItem statisticsView = new JRadioButtonMenuItem("Statistics");
        statisticsView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_DOWN_MASK));
        statisticsView.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new Statistics(cal);
        });
        viewGroup.add(standardView);
        viewGroup.add(scientificView);
        viewGroup.add(programmerView);
        viewGroup.add(statisticsView);
        viewMenu.add(standardView);
        viewMenu.add(scientificView);
        viewMenu.add(programmerView);
        viewMenu.add(statisticsView);
        viewMenu.addSeparator();
        JMenuItem historyItem = new JMenuItem("History");
        historyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        historyItem.addActionListener(e -> {
            dispose();
            new History();
        });
        viewMenu.add(historyItem);
        JMenuItem digitGroupingItem = new JMenuItem("Digit Grouping");
        viewMenu.add(digitGroupingItem);
        viewMenu.addSeparator();
        ButtonGroup viewGroup2 = new ButtonGroup();
        JRadioButtonMenuItem basicItem = new JRadioButtonMenuItem("Basic");
        basicItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK));
      basicItem.setSelected(true);
        JRadioButtonMenuItem unitConversionItem = new JRadioButtonMenuItem("Unit Conversion");
        unitConversionItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
        unitConversionItem.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new Unit(cal);
        });
        JRadioButtonMenuItem dateCalculationItem = new JRadioButtonMenuItem("Date Calculation");
        dateCalculationItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        dateCalculationItem.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new Date(cal);
        });
        viewGroup2.add(basicItem);
        viewGroup2.add(unitConversionItem);
        viewGroup2.add(dateCalculationItem);
        viewMenu.add(basicItem);
        viewMenu.add(unitConversionItem);
        viewMenu.add(dateCalculationItem);
        JMenu worksheetsMenu = new JMenu("Worksheets");
        JRadioButtonMenuItem mortgageItem = new JRadioButtonMenuItem("Mortgage");
        mortgageItem.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new Mortgage(cal);
        });
        JRadioButtonMenuItem vehicleLeaseItem = new JRadioButtonMenuItem("Vehicle lease");
        vehicleLeaseItem.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new Lease(cal);
        });
        JRadioButtonMenuItem fuelEconomyMPGItem = new JRadioButtonMenuItem("Fuel economy (mpg)");
        fuelEconomyMPGItem.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new Fuel(cal);
        });
        JRadioButtonMenuItem fuelEconomyL100kmItem = new JRadioButtonMenuItem("Fuel economy (L/100 km)");
        fuelEconomyL100kmItem.addActionListener(e -> {
            dispose();
            Calculator cal = new Calculator();
            new FuelE(cal);
        });
        viewGroup2.add(mortgageItem);
        viewGroup2.add(vehicleLeaseItem);
        viewGroup2.add(fuelEconomyMPGItem);
        viewGroup2.add(fuelEconomyL100kmItem);
        worksheetsMenu.add(mortgageItem);
        worksheetsMenu.add(vehicleLeaseItem);
        worksheetsMenu.add(fuelEconomyMPGItem);
        worksheetsMenu.add(fuelEconomyL100kmItem);
        viewMenu.add(worksheetsMenu);
        menuBar.add(viewMenu);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem copyOption = new JMenuItem("Copy");
        copyOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        JMenuItem pasteOption = new JMenuItem("Paste");
        pasteOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        pasteOption.setEnabled(false);
        copyOption.addActionListener(e -> {
            try {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                String data = "Sample data";
                StringSelection selection = new StringSelection(data);
                clipboard.setContents(selection, null);
                pasteOption.setEnabled(true);
                System.out.println("Data copied to clipboard");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        pasteOption.addActionListener(e -> {
            try {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                String data = (String) clipboard.getData(DataFlavor.stringFlavor);
                System.out.println("Pasted text: " + data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        editMenu.add(copyOption);
        editMenu.add(pasteOption);
        editMenu.addSeparator();
        JMenu historyMenu = new JMenu("History");
        editMenu.add(historyMenu);
        menuBar.add(editMenu);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem viewOption = new JMenuItem("View Help");
        helpMenu.add(viewOption);
        helpMenu.addSeparator();
        JMenuItem aboutOption = new JMenuItem("About Calculator");
        helpMenu.add(aboutOption);
        menuBar.add(helpMenu);

        return menuBar;
    }

    public Calculator() {
        JMenuBar menuBar = createMenu();
        setJMenuBar(menuBar);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\Hp\\Desktop\\5 semester\\SCD\\Calculator\\src\\WhatsApp Image 2024-09-28 at 12.21.51_bd9d5d60.jpg");
        setIconImage(logoIcon.getImage());
        setContentPane(StandardCalc);

        a0TextField.setText("0");

        setVisible(true);

        MCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoryValue = 0;
                a0TextField.setText("");
                System.out.println("Memory cleared.");
            }
        });
        MRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(Double.toString(memoryValue));
                System.out.println("Memory recalled: " + memoryValue);
            }
        });
        MSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    memoryValue = Double.parseDouble(a0TextField.getText());
                    System.out.println("Memory stored: " + memoryValue);
                } catch (NumberFormatException ex) {
                    System.out.println("No valid number to store in memory.");
                }
            }
        });
        mButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    memoryValue += Double.parseDouble(a0TextField.getText());
                    System.out.println("Added to memory: " + memoryValue);
                    a0TextField.setText(Double.toString(memoryValue));
                } catch (NumberFormatException ex) {
                    System.out.println("No valid number to add to memory.");
                }
            }
        });
        mButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    memoryValue -= Double.parseDouble(a0TextField.getText());
                    System.out.println("Subtracted from memory: " + memoryValue);
                    a0TextField.setText(Double.toString(memoryValue));
                } catch (NumberFormatException ex) {
                    System.out.println("No valid number to subtract from memory.");
                }

            }
        });
        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText("0");
                System.out.println("Current entry cleared.");
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText("0");
                memoryValue = 0;
                System.out.println("All cleared.");
            }
        });

        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("0");
            }
        });
        a1Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("9");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField(".");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = a0TextField.getText();
                if (!currentText.isEmpty()) {
                    a0TextField.setText(currentText.substring(0, currentText.length() - 1));
                    if (a0TextField.getText().isEmpty()) {
                        a0TextField.setText("0");
                    }
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
                operator = "+";
                operatorPressed = true;
                a0TextField.setText("");
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
                operator = "-";
                operatorPressed = true;
                a0TextField.setText("");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
                operator = "/";
                operatorPressed = true;
                a0TextField.setText("");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
                operator = "*";
                operatorPressed = true;
                a0TextField.setText("");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
                operator = "";
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!a0TextField.getText().isEmpty()) {
                    double value = Double.parseDouble(a0TextField.getText());
                    value = -value;
                    a0TextField.setText(Double.toString(value));
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!a0TextField.getText().isEmpty()) {
                    double value = Double.parseDouble(a0TextField.getText());
                    if (value >= 0) {
                        value = Math.sqrt(value);
                        a0TextField.setText(Double.toString(value));
                    } else {
                        a0TextField.setText("Error");
                    }
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!a0TextField.getText().isEmpty()) {
                    double value = Double.parseDouble(a0TextField.getText());
                    value = value / 100;
                    a0TextField.setText(Double.toString(value));
                }
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!a0TextField.getText().isEmpty()) {
                    double value = Double.parseDouble(a0TextField.getText());
                    if (value != 0) {
                        value = 1 / value;
                        a0TextField.setText(Double.toString(value));
                    } else {
                        a0TextField.setText("Error");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new Calculator();

    }
}