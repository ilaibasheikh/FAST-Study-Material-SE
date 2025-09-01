import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

class Person {
    String fullName;
    String contactNumber;
    String emailAddress;

    public Person(String fullName, String contactNumber, String emailAddress) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return fullName + " - " + contactNumber + " - " + emailAddress;
    }

    @Override
    public int hashCode() {
        return fullName.toLowerCase().hashCode() + contactNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return fullName.equalsIgnoreCase(other.fullName) && contactNumber.equals(other.contactNumber);
    }
}

public class task4 extends JFrame{
    private JTextField fullNameField;
    private JTextField contactField;
    private JButton saveButton;
    private JTable contactsTable;
    private JTextField emailField;
    private JButton findButton;
    private JButton resetButton;
    private JTextField searchField;
    private JPanel mainPanel;

    private HashSet<Person> contactList = new HashSet<>();
    private DefaultTableModel tableModel;

    public task4() {
        setContentPane(mainPanel);
        setTitle("Contact List Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        tableModel = new DefaultTableModel(new Object[]{"Full Name", "Contact Number", "Email Address"}, 0);
        contactsTable.setModel(tableModel);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveContact();
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findContact();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSearch();
            }
        });
    }

    private void saveContact() {
        String fullName = fullNameField.getText().trim();
        String contactNumber = contactField.getText().trim();
        String emailAddress = emailField.getText().trim();

        if (fullName.isEmpty() || contactNumber.isEmpty() || emailAddress.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }

        Person newContact = new Person(fullName, contactNumber, emailAddress);

        if (contactList.contains(newContact)) {
            JOptionPane.showMessageDialog(null, "Contact with the same name and phone number already exists.");
        } else {
            contactList.add(newContact);
            tableModel.addRow(new Object[]{fullName, contactNumber, emailAddress});
            clearInputFields();
        }
    }

    private void findContact() {
        String searchQuery = searchField.getText().trim();
        boolean isFound = false;
        tableModel.setRowCount(0);

        for (Person contact : contactList) {
            if (contact.fullName.equalsIgnoreCase(searchQuery) || contact.contactNumber.equals(searchQuery)) {
                tableModel.addRow(new Object[]{contact.fullName, contact.contactNumber, contact.emailAddress});
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            JOptionPane.showMessageDialog(null, "No contact found.");
        }
    }

    private void resetSearch() {
        tableModel.setRowCount(0);
        for (Person contact : contactList) {
            tableModel.addRow(new Object[]{contact.fullName, contact.contactNumber, contact.emailAddress});
        }
    }

    private void clearInputFields() {
        fullNameField.setText("");
        contactField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        new task4();
    }
}
