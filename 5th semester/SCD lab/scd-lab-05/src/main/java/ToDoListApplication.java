import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoListApplication {
    private JTable taskTable;
    private JButton addButton;
    private JTextField textField1;
    private JButton markAsCompleteButton;
    private JButton clearAllButton;
    private JPanel panel1;

    private ArrayList<String> tasks = new ArrayList<>();
    private DefaultTableModel tableModel;

    public ToDoListApplication() {
        tableModel = new DefaultTableModel(new Object[]{"Tasks"}, 0);
        taskTable.setModel(tableModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        markAsCompleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskAsComplete();
            }
        });

        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTasks();
            }
        });
    }

    private void addTask() {
        String taskDescription = textField1.getText().trim();
        if (taskDescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a task.");
            return;
        }

        tasks.add(taskDescription);
        tableModel.addRow(new Object[]{taskDescription});
        textField1.setText("");
    }

    private void markTaskAsComplete() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a task to mark as complete.");
            return;
        }

        tasks.remove(selectedRow);
        tableModel.removeRow(selectedRow);
    }

    private void clearAllTasks() {
        tasks.clear();
        tableModel.setRowCount(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List Application");
        frame.setContentPane(new ToDoListApplication().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
