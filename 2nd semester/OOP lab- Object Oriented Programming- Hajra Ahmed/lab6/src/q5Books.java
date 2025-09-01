class Books {
    protected int bookID;
    protected String bookName;
    protected String bookAuthor;
    protected String ISBN;
    protected double price;

    public Books(int id, String name, String author, String isbn, double price) {
        bookID = id;
        bookName = name;
        bookAuthor = author;
        ISBN = isbn;
        this.price = price;
    }
}

class Category1 extends Books {
    private String category;

    public Category1(int id, String name, String author, String isbn, double price, String category) {
        super(id, name, author, isbn, price);
        this.category = category;
    }

    public void display() {
        System.out.println("Category: " + category);
        System.out.println("Book ID: " + bookID);
        System.out.println("Book Name: " + bookName);
        System.out.println("Book Author: " + bookAuthor);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Price: " + price);
        System.out.println();
    }
    public static void main(String[] args) {
        Category1 book1 = new Category1(1, "Java", "Laiba", "123456", 40.99, "Java");
        Category1 book2 = new Category1(2, "OOP", "Fatima", "789012", 42.99, "OOP");
        Category1 book3 = new Category1(3, "C ", "Sheikh", "345678", 38.99, "C");

        book1.display();
        book2.display();
        book3.display();

        // Upcasting child object to parent class object
        Books book = (Books) new Category1(4, "C++", "Noor", "901234", 80.99, "C++");
       // System.out.println(book);
    }
}


