import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPopupMenuExample extends JFrame {

    public JPopupMenuExample() {
        setTitle("JPopupMenu Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.BorderLayout());

        // Create a JPanel
        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(createPopupMenu());
        
        // Add a MouseListener to show the popup menu on right-click
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    createPopupMenu().show(e.getComponent(), e.getX(), e.getY());
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    createPopupMenu().show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    private JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        // Create menu items
        JMenuItem item1 = new JMenuItem("Option 1");
        JMenuItem item2 = new JMenuItem("Option 2");
        JMenuItem item3 = new JMenuItem("Option 3");

        // Add action listeners
        item1.addActionListener(e -> System.out.println("Option 1 selected"));
        item2.addActionListener(e -> System.out.println("Option 2 selected"));
        item3.addActionListener(e -> System.out.println("Option 3 selected"));

        // Add items to the popup menu
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);

        // Add a separator
        popupMenu.add(new JSeparator());

        // Add a menu item with an icon
        JMenuItem item4 = new JMenuItem("Option with Icon");
        item4.setIcon(new ImageIcon("icon.png")); // Example icon
        popupMenu.add(item4);

        return popupMenu;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JPopupMenuExample::new);
    }
}
