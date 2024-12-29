import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarExample extends JFrame {

    public MenuBarExample() {
        setTitle("MenuBar Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // Create the "File" menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create menu items for "File" menu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        // Add a separator
        fileMenu.add(new JSeparator());

        // Create a "Quit" menu item
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(quitItem);

        // Create the "Edit" menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        // Create menu items for "Edit" menu
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Create a "Preferences" menu
        JMenu preferencesMenu = new JMenu("Preferences");
        menuBar.add(preferencesMenu);

        // Create a JCheckBoxMenuItem
        JCheckBoxMenuItem darkModeItem = new JCheckBoxMenuItem("Dark Mode");
        darkModeItem.addActionListener(e -> {
            if (darkModeItem.isSelected()) {
                getContentPane().setBackground(Color.DARK_GRAY);
            } else {
                getContentPane().setBackground(Color.WHITE);
            }
        });
        preferencesMenu.add(darkModeItem);

        // Create a JRadioButtonMenuItem
        JMenu colorMenu = new JMenu("Color Scheme");
        preferencesMenu.add(colorMenu);

        JRadioButtonMenuItem lightColorItem = new JRadioButtonMenuItem("Light");
        JRadioButtonMenuItem darkColorItem = new JRadioButtonMenuItem("Dark");
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(lightColorItem);
        colorGroup.add(darkColorItem);

        colorMenu.add(lightColorItem);
        colorMenu.add(darkColorItem);

        // Add action listeners to radio buttons
        lightColorItem.addActionListener(e -> getContentPane().setBackground(Color.WHITE));
        darkColorItem.addActionListener(e -> getContentPane().setBackground(Color.DARK_GRAY));

        // Set the menu bar
        setJMenuBar(menuBar);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuBarExample::new);
    }
}
