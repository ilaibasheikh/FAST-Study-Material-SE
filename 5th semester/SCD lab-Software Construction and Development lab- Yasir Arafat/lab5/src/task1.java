import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class task1 extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel Book;
    private JTextField TitleField;
    private JTextField AuthorField;
    private JTextField ISBNField;
    private JButton addButton;
    private JPanel View;
    private JPanel Add;
    private JTable ViewTable;
    private JPanel Search;
    private JTextField SearchField;
    private JButton searchButton;
    private JPanel Delete;
    private JTextField DeleteField;
    private JButton deleteButton;
    private JTable SearchTable;
    private ArrayList<Book> bookList;
    private DefaultTableModel viewTableModel;
    private DefaultTableModel searchTableModel;

    public task1() {
        setContentPane(tabbedPane1);
        setTitle("Book Library Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bookList = new ArrayList<>();
        viewTableModel = new DefaultTableModel(new Object[]{"Title", "Author", "ISBN"}, 0);
        searchTableModel = new DefaultTableModel(new Object[]{"Title", "Author", "ISBN"}, 0);

        ViewTable.setModel(viewTableModel);
        SearchTable.setModel(searchTableModel);


        addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = TitleField.getText();
            String author = AuthorField.getText();
            String isbn = ISBNField.getText();

            if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty()) {
                Book b1 = new Book(title, author, isbn);
                bookList.add(b1);
                updateTable(viewTableModel, bookList);
                JOptionPane.showMessageDialog(Book, "Book added successfully!");

                TitleField.setText("");
                AuthorField.setText("");
                ISBNField.setText("");
            } else {
                JOptionPane.showMessageDialog(Book, "Please fill all fields.");
            }
        }
    });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = SearchField.getText();
                if (query.isEmpty()) {
                    JOptionPane.showMessageDialog(Book, "Please enter an ISBN or Title to search.");
                    return;
                }

                searchTableModel.setRowCount(0);

                for (Book book : bookList) {
                    if (book.getIsbn().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                        searchTableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn()});
                    }
                }

                if (searchTableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(Book, "No book found.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbnToDelete = DeleteField.getText();
                if (isbnToDelete.isEmpty()) {
                    JOptionPane.showMessageDialog(Book, "Please enter an ISBN to delete.");
                    return;
                }

                boolean removed = bookList.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbnToDelete));

                if (removed) {
                    updateTable(viewTableModel,bookList);
                    JOptionPane.showMessageDialog(Book, "Book deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(Book, "No book found with the given ISBN.");
                }
            }
        });

    }
    private void updateTable(DefaultTableModel tableModel, ArrayList<Book> books) {
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn()});
        }
    }

    public static void main(String[] args) {
        new task1();
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

