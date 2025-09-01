import javax.swing.*;
import java.awt.event.*;

public class AdjustmentValueChangedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Adjustment Value Changed Example");
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);

        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                System.out.println("Scroll bar value changed to: " + e.getValue());
            }
        });

        frame.add(scrollBar);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
