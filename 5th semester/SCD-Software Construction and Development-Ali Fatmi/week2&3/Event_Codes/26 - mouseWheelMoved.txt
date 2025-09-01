import javax.swing.*;
import java.awt.event.*;

public class MouseWheelMovedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Wheel Moved Example");
        JTextArea textArea = new JTextArea(20, 30);

        textArea.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    System.out.println("Mouse wheel moved up.");
                } else {
                    System.out.println("Mouse wheel moved down.");
                }
            }
        });

        frame.add(new JScrollPane(textArea));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
