import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class task3 extends JFrame {
    private JTable studentTable;
    private JTextField averageField;
    private JButton submitButton;
    private JTextField studentNameField;
    private JTextField studentGradeField;
    private JTextField minGradeField;
    private JTextField maxGradeField;
    private JPanel mainPanel;

    private TreeMap<String, Integer> studentRecords = new TreeMap<>();

    public task3() {
        setContentPane(mainPanel);
        setTitle("Student Grading System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudentRecord();
            }
        });
    }

    private void addStudentRecord() {
        String studentName = studentNameField.getText().trim();
        String gradeText = studentGradeField.getText().trim();

        if (studentName.isEmpty() || gradeText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter both name and grade.");
            return;
        }

        try {
            int grade = Integer.parseInt(gradeText);
            if (grade < 0 || grade > 100) {
                JOptionPane.showMessageDialog(null, "Grade must be between 0 and 100.");
                return;
            }

            studentRecords.put(studentName, grade);
            refreshStudentTable();
            calculateGradeStatistics();
            clearInputFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid grade.");
        }
    }

    private void refreshStudentTable() {
        String[] columnHeaders = {"Student Name", "Grade"};
        DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);

        for (Map.Entry<String, Integer> entry : studentRecords.entrySet()) {
            model.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }

        studentTable.setModel(model);
    }

    private void calculateGradeStatistics() {
        if (studentRecords.isEmpty()) {
            averageField.setText("N/A");
            minGradeField.setText("N/A");
            maxGradeField.setText("N/A");
            return;
        }

        int totalGrades = 0;
        int minGrade = Integer.MAX_VALUE;
        int maxGrade = Integer.MIN_VALUE;

        for (int grade : studentRecords.values()) {
            totalGrades += grade;
            if (grade < minGrade) minGrade = grade;
            if (grade > maxGrade) maxGrade = grade;
        }

        double average = (double) totalGrades / studentRecords.size();
        averageField.setText(String.format("%.2f", average));
        minGradeField.setText(String.valueOf(minGrade));
        maxGradeField.setText(String.valueOf(maxGrade));
    }

    private void clearInputFields() {
        studentNameField.setText("");
        studentGradeField.setText("");
    }

    public static void main(String[] args) {
        new task3();
    }
}

