import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSpinnerExample extends JFrame {

    public DateSpinnerExample() {
        setTitle("Date JSpinner Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a SpinnerDateModel with the current date
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner dateSpinner = new JSpinner(dateModel);

        // Create a JSpinner.DateEditor to format the date
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);

        // Create a JButton to retrieve the date
        JButton getDateButton = new JButton("Get Date");
        getDateButton.addActionListener(e -> {
            Date date = (Date) dateSpinner.getValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            JOptionPane.showMessageDialog(null, "Selected date: " + dateFormat.format(date));
        });

        // Add components to the frame
        add(new JLabel("Select a date:"));
        add(dateSpinner);
        add(getDateButton);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new DateSpinnerExample();
    }
}
