import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class task5 extends  JFrame {
    private JTable taskTable;
    private JButton addTaskButton;
    private JTextField taskInputField;
    private JButton completeTaskButton;
    private JButton clearTasksButton;
    private JPanel mainPanel;

    private ArrayList<String> taskList = new ArrayList<>();
    private DefaultTableModel taskTableModel;

    public task5() {
        setContentPane(mainPanel);
        setTitle("To-Do List Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        taskTableModel = new DefaultTableModel(new Object[]{"Task Description"}, 0);
        taskTable.setModel(taskTableModel);

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTask();
            }
        });

        completeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskComplete();
            }
        });

        clearTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTasks();
            }
        });
    }

    private void addNewTask() {
        String taskDescription = taskInputField.getText().trim();
        if (taskDescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a task.");
            return;
        }

        taskList.add(taskDescription);
        taskTableModel.addRow(new Object[]{taskDescription});
        taskInputField.setText("");
    }

    private void markTaskComplete() {
        int selectedTaskIndex = taskTable.getSelectedRow();
        if (selectedTaskIndex == -1) {
            JOptionPane.showMessageDialog(null, "Please select a task to mark as complete.");
            return;
        }

        taskList.remove(selectedTaskIndex);
        taskTableModel.removeRow(selectedTaskIndex);
    }

    private void clearAllTasks() {
        taskList.clear();
        taskTableModel.setRowCount(0);
    }

    public static void main(String[] args) {
       new task5();
    }
}
