class book {

    private String title;
    private String author;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void tostring(){
        System.out.println(this.title);
        System.out.println(this.author);
        System.out.println(this.price);
    }
}

public class book1{
    public static void main(String[] args) {
        book b1 = new book ("Great Expectations" , "Charles Dickens" , 79.75);
        System.out.println("Name : " +b1.getTitle());
        System.out.println("Author : " +b1.getAuthor());
        System.out.println("Price : " +b1.getPrice());

    }
}
