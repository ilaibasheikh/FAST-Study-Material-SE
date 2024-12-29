import javax.swing.*;
import java.awt.event.*;

public class MenuKeyPressedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Key Pressed Example");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Open");

        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Add KeyListener to the frame
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not used in this example
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not used in this example
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Make sure the frame is focusable to receive key events
        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }
}
//import javax.swing.*;
//import javax.swing.event.MenuKeyEvent;
//import javax.swing.event.MenuKeyListener;
//import java.awt.event.*;
//
//public class MenuKeyPressedExample extends JFrame {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Menu Key Pressed Example");
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("File");
//        JMenuItem menuItem = new JMenuItem("Open");
//
//        menu.add(menuItem);
//        menuBar.add(menu);
//        frame.setJMenuBar(menuBar);
//
//        menuBar.addMenuKeyListener(new MenuKeyListener() {
//            @Override
//            public void menuKeyPressed(MenuKeyEvent e) {
//                System.out.println("Menu key pressed: " + e.getKeyCode());
//            }
//
//            @Override
//            public void menuKeyReleased(MenuKeyEvent e) {
//                // Not used in this example
//            }
//
//            @Override
//            public void menuKeyTyped(MenuKeyEvent e) {
//                // Not used in this example
//            }
//        });
//
//        frame.setSize(300, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
//}

