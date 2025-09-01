import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookLibraryManagement {

    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField DeleteField;
    private JButton addButton;
    private JTable bookTable;

    private JTable searchResultTable;
    private JButton searchButton;
    private JButton deleteButton;
    private JTextField searchField;

    private ArrayList<Book> books = new ArrayList<>();
    private DefaultTableModel tableModel;
    private DefaultTableModel searchTableModel;

    public BookLibraryManagement() {
        tableModel = new DefaultTableModel(new Object[]{"Title", "Author", "ISBN"}, 0);
        bookTable.setModel(tableModel);
        searchTableModel = new DefaultTableModel(new Object[]{"Title", "Author", "ISBN"}, 0);
        searchResultTable.setModel(searchTableModel);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();

        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "Please fill all fields.");
            return;
        }

        Book book = new Book(title, author, isbn);
        books.add(book);

        tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn()});

        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");

        JOptionPane.showMessageDialog(mainPanel, "Book added successfully!");
    }

    private void searchBook() {
        String query = searchField.getText();
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "Please enter an ISBN or Title to search.");
            return;
        }

        searchTableModel.setRowCount(0);

        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                searchTableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn()});
            }
        }

        if (searchTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(mainPanel, "No book found.");
        }
    }
    private void deleteBook() {
        String isbnToDelete = DeleteField.getText();
        if (isbnToDelete.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "Please enter an ISBN to delete.");
            return;
        }

        boolean removed = books.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbnToDelete));

        if (removed) {
            refreshTable();
            JOptionPane.showMessageDialog(mainPanel, "Book deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(mainPanel, "No book found with the given ISBN.");
        }
    }
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn()});
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Book Library Management");
        frame.setContentPane(new BookLibraryManagement().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
 class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
