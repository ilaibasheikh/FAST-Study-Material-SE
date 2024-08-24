import java.util.Scanner;

public class q4Main {
    public static void main(String[] args) {
        System.out.println("Laiba Fatima 22K-5195");
        Scanner A = new Scanner(System.in);
        Movie m1 = new Movie("Lion King", "10 Am");
        Movie m2 = new Movie("tangled", "12 pm");
        m1.display();
        m2.display();
        int id;
        System.out.println("Enter id");
        id = A.nextInt();
        int digits = id /100;

        Ticket ticket = new Ticket(5,7,digits);

   if(!ticket.isSold()){
       ticket.sellTicket();;
       ticket.displayTicket();
   }
    }
}
class Movie{

    private  String moviename;
    private  String showtime;

    public Movie(String name, String showTime) {
        this.moviename = name;
        this.showtime = showTime;
    }
    void display(){
        System.out.println("movie " +moviename);
        System.out.println("showtime "+showtime);
    }
    public String getName() {
        return moviename;
    }

    public String getShowTime() {
        return showtime;
    }
}
class Ticket {
    Scanner A= new Scanner(System.in);
    int rowNumber;
    int seatNumber;
    int ticketID;
    private boolean isSold;

    public Ticket(int rowNumber, int seatNumber, int ticketID) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.ticketID = ticketID;
        this.isSold = false;
    }
    public boolean isSold() {
        return isSold;
    }

    public void sellTicket() {
        this.isSold = true;
    }
    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketID + " | Row: " + rowNumber + " | Seat: " + seatNumber + " | Status: " + (isSold ? "SOLD" : "AVAILABLE"));
    }
}