import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedDesktopPaneExample extends JFrame {

    private JDesktopPane desktopPane;
    private int frameCount = 0;

    public AdvancedDesktopPaneExample() {
        setTitle("Advanced JDesktopPane Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        add(desktopPane);

        JToolBar toolBar = new JToolBar();
        JButton newFrameButton = new JButton("New Frame");
        JButton cascadeButton = new JButton("Cascade");
        JButton tileButton = new JButton("Tile");

        toolBar.add(newFrameButton);
        toolBar.add(cascadeButton);
        toolBar.add(tileButton);
        add(toolBar, "North");

        newFrameButton.addActionListener(e -> createInternalFrame());
        cascadeButton.addActionListener(e -> cascadeInternalFrames());
        tileButton.addActionListener(e -> tileInternalFrames());

        setVisible(true);
    }

    private void createInternalFrame() {
        JInternalFrame internalFrame = new JInternalFrame("Frame " + (++frameCount), true, true, true, true);
        internalFrame.setSize(250, 150);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);

        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    private void cascadeInternalFrames() {
        JInternalFrame[] frames = desktopPane.getAllFrames();
        int x = 0, y = 0;
        for (JInternalFrame frame : frames) {
            frame.setLocation(x, y);
            x += 30;
            y += 30;
        }
    }

    private void tileInternalFrames() {
        JInternalFrame[] frames = desktopPane.getAllFrames();
        int frameWidth = desktopPane.getWidth() / frames.length;
        int frameHeight = desktopPane.getHeight();

        for (int i = 0; i < frames.length; i++) {
            frames[i].setSize(frameWidth, frameHeight);
            frames[i].setLocation(i * frameWidth, 0);
        }
    }

    public static void main(String[] args) {
        new AdvancedDesktopPaneExample();
    }
}

