import javax.swing.*;

public class JLabelHtmlExample extends JFrame {

    public JLabelHtmlExample() {
        setTitle("JLabel with HTML Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel htmlLabel = new JLabel("<html><h1>Welcome!</h1>"
                + "<p>This is an example of a <b>JLabel</b> with <font color='red'>HTML</font> content.</p>"
                + "<p><i>HTML</i> allows you to <u>format</u> text easily.</p>"
                + "</html>");

        htmlLabel.setHorizontalAlignment(JLabel.CENTER);
        add(htmlLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelHtmlExample();
    }
}
