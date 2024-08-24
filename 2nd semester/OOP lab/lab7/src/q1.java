class item {
    String title;
    String author;
    int year;

    public String toString(){
        return title + " " +author + " "+year;
    }

    public item() {
    }

    public item(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class book extends item{
    String publisher;
    int isbn;

    public String toString(){
        return title + " " +author + " "+year + " " +publisher + " " +isbn;
    }

    public book(String title, String author, int year, String publisher, int isbn) {
        super(title, author, year);
        this.publisher = publisher;
        this.isbn = isbn;
    }
}


class magazine extends item{
    String publisher;
    int issuenum;

    public String toString(){
        return title + " " +author + " "+year + " " +publisher + " " +issuenum;
    }


    public magazine(String title, String author, int year, String publisher, int issuenum) {
        super(title, author, year);
        this.publisher = publisher;
        this.issuenum = issuenum;
    }
}

class dvd extends item{
    String director;
    int length;

    public String toString(){
        return title + " " +author + " "+year + " " +director + " " +length;
    }


    public dvd(String title, String author, int year, String director, int length) {
        super(title, author, year);
        this.director = director;
        this.length = length;
    }
}

public class q1{
    public static void main(String[] args) {
        item i = new item("Alchemist","Paulo", 2003);
        book b = new book("Alchemist","Paulo", 2003, "Penguin", 12345 );
        magazine m = new magazine("Alchemist","Paulo", 2003, "Vogue", 12);
        dvd d = new dvd("Alchemist","Paulo", 2003, "Dave", 250);

        //by printing sout(object), all details are dispayed as string too.
        System.out.println(i.toString());
        System.out.println(b.toString());
        System.out.println(m.toString());
        System.out.println(d.toString());
    }
}