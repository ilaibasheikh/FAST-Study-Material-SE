import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragLayeredPaneExample extends JFrame {

    private JLayeredPane layeredPane;
    private JLabel dragLabel;

    public DragLayeredPaneExample() {
        setTitle("Drag and Drop with JLayeredPane");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layeredPane = new JLayeredPane();

        // Background label
        JLabel backgroundLabel = new JLabel("Background Label");
        backgroundLabel.setOpaque(true);
        backgroundLabel.setBackground(Color.LIGHT_GRAY);
        backgroundLabel.setBounds(50, 50, 200, 100);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Drag label
        dragLabel = new JLabel("Drag Me!");
        dragLabel.setOpaque(true);
        dragLabel.setBackground(Color.YELLOW);
        dragLabel.setBounds(100, 100, 100, 50);
        layeredPane.add(dragLabel, JLayeredPane.DRAG_LAYER);

        // Add mouse listeners for dragging
        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Point lastLocation;

            @Override
            public void mousePressed(MouseEvent e) {
                lastLocation = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point newLocation = e.getLocationOnScreen();
                Point oldLocation = dragLabel.getLocation();
                dragLabel.setLocation(oldLocation.x + newLocation.x - lastLocation.x, 
                                      oldLocation.y + newLocation.y - lastLocation.y);
                lastLocation = e.getPoint();
            }
        };
        dragLabel.addMouseListener(mouseAdapter);
        dragLabel.addMouseMotionListener(mouseAdapter);

        add(layeredPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DragLayeredPaneExample();
    }
}
