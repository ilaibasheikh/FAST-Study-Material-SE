import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber + " - " + email;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode() + phoneNumber.hashCode(); // Lowercase for name
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return name.equalsIgnoreCase(other.name) && phoneNumber.equals(other.phoneNumber);
    }
}

public class ContactListApplication {
    private JTextField nameField;
    private JTextField numField;
    private JButton addButton;
    private JTable table1;
    private JTextField emailField;
    private JButton searchButton;
    private JButton clearButton;
    private JTextField searchField;
    private JPanel panel1;

    private HashSet<Contact> contacts = new HashSet<>();
    private DefaultTableModel tableModel;

    public ContactListApplication() {
        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Email"}, 0);
        table1.setModel(tableModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSearch();
            }
        });
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String phoneNumber = numField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }

        Contact newContact = new Contact(name, phoneNumber, email);

        if (contacts.contains(newContact)) {
            JOptionPane.showMessageDialog(null, "Contact with the same name and phone number already exists.");
        } else {
            contacts.add(newContact);
            tableModel.addRow(new Object[]{name, phoneNumber, email});
            clearFields();
        }
    }

    private void searchContact() {
        String searchTerm = searchField.getText().trim();
        boolean found = false;
        tableModel.setRowCount(0);

        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(searchTerm) || contact.phoneNumber.equals(searchTerm)) {
                tableModel.addRow(new Object[]{contact.name, contact.phoneNumber, contact.email});
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "No contact found.");
        }
    }

    private void clearSearch() {
        tableModel.setRowCount(0);
        for (Contact contact : contacts) {
            tableModel.addRow(new Object[]{contact.name, contact.phoneNumber, contact.email});
        }
    }

    private void clearFields() {
        nameField.setText("");
        numField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Contact List Application");
        frame.setContentPane(new ContactListApplication().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
