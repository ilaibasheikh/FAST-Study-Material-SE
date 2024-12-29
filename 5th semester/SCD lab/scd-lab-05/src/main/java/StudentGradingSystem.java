import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class StudentGradingSystem {
    private JTable studentTable;
    private JTextField classAverageField;
    private JButton addButton;
    private JTextField nameField;
    private JTextField gradeField;
    private JTextField lowestGradeField;
    private JTextField highestGradeField;
    private JPanel panel1;

    private TreeMap<String, Integer> studentGrades = new TreeMap<>();

    public StudentGradingSystem() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
    }

    private void addStudent() {
        String studentName = nameField.getText().trim();
        String gradeText = gradeField.getText().trim();

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

            studentGrades.put(studentName, grade);
            updateStudentTable();
            calculateStatistics();
            clearInputs();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid grade.");
        }
    }

    private void updateStudentTable() {
        String[] columnNames = {"Student Name", "Grade"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            model.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }

        studentTable.setModel(model);
    }

    private void calculateStatistics() {
        if (studentGrades.isEmpty()) {
            classAverageField.setText("N/A");
            lowestGradeField.setText("N/A");
            highestGradeField.setText("N/A");
            return;
        }

        int totalGrades = 0;
        int lowestGrade = Integer.MAX_VALUE;
        int highestGrade = Integer.MIN_VALUE;

        for (int grade : studentGrades.values()) {
            totalGrades += grade;
            if (grade < lowestGrade) lowestGrade = grade;
            if (grade > highestGrade) highestGrade = grade;
        }

        double average = (double) totalGrades / studentGrades.size();
        classAverageField.setText(String.format("%.2f", average));
        lowestGradeField.setText(String.valueOf(lowestGrade));
        highestGradeField.setText(String.valueOf(highestGrade));
    }

    private void clearInputs() {
        nameField.setText("");
        gradeField.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Grading System");
        frame.setContentPane(new StudentGradingSystem().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}