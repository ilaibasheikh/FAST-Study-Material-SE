import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class task6a extends JFrame {
    public JPanel Dashboard;
    private JTabbedPane task6a;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton registerButton;
    private JTextArea textArea1;
    private JComboBox comboBox4;
    private JButton updateButton;
    private JPanel task6aa;

    String course1, course2, course3;

    private void validateCourseSelection() {

        course1 = (String) comboBox1.getSelectedItem();
        course2 = (String) comboBox2.getSelectedItem();
        course3 = (String) comboBox3.getSelectedItem();


        if (course1.equals(course2) || course1.equals(course3) || course2.equals(course3)) {
            JOptionPane.showMessageDialog(registerButton, "Please select different courses for each selection!", "Duplicate Courses", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(registerButton, "Go to 'View' tab", "Success", JOptionPane.INFORMATION_MESSAGE);
            textArea1.setText(course1 +"\n" + course2 +"\n" + course3);

            comboBox4.removeAllItems();
            comboBox4.addItem(course1);
            comboBox4.addItem(course2);
            comboBox4.addItem(course3);

        }
    }

    public task6a( ){
        setTitle("FlexStudents");
        setContentPane(task6a);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea1.setEditable(false);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateCourseSelection();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseToDrop = (String) comboBox4.getSelectedItem();

                if (courseToDrop != null) {
                    comboBox4.removeItem(courseToDrop);

                    StringBuilder updatedCourses = new StringBuilder();

                    if (!course1.equals(courseToDrop)) {
                        updatedCourses.append(course1).append("\n");
                    }
                    if (!course2.equals(courseToDrop)) {
                        updatedCourses.append(course2).append("\n");
                    }
                    if (!course3.equals(courseToDrop)) {
                        updatedCourses.append(course3).append("\n");
                    }

                    textArea1.setText(updatedCourses.toString());
                    JOptionPane.showMessageDialog(updateButton, "Go to 'View' tab", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(updateButton, "No course selected to drop!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new task6a();


    }
}

