import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.text.SimpleDateFormat;

public class DateFormattedTextFieldExample extends JFrame {

    public DateFormattedTextFieldExample() {
        setTitle("Date JFormattedTextField Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a SimpleDateFormat for formatting date input
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);

        // Create a JFormattedTextField with the date formatter
        JFormattedTextField dateField = new JFormattedTextField(dateFormatter);
        dateField.setColumns(10);
        dateField.setValue(new java.util.Date()); // Set initial value

        // Add the JFormattedTextField to the frame
        add(new JLabel("Enter a date (yyyy-MM-dd):"));
        add(dateField);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new DateFormattedTextFieldExample();
    }
}
