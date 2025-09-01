import java.util.Scanner;

public class holiday {
    public String name;
    public int  day;
    public String month;

    public holiday(){

    }
    //q4
    public holiday (holiday h){
        name = h.name;
        day = h.day;
        month = h.month;
    }
    //part a
    public holiday(String n, int d, String m) {
        this.name =n;
        this.day = d;
        this.month = m;
    }

    public void display(){
        System.out.println("Name " +name);
        System.out.println("Day " + day);
        System.out.println("Month " +month);
    }
//part b
    public boolean inSameMonth( holiday h1 , holiday h2 ){
        return (h1.month.equals(h2.month));

    }

    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);

        System.out.println("Enter name of holiday 1");
        System.out.println("Enter day of holiday 1");
        System.out.println("Enter month of holiday 1");
        holiday h1 = new holiday( A.next(), A.nextInt(), A.next());


        System.out.println("Enter name of holiday 2");
        System.out.println("Enter day of holiday 2");
        System.out.println("Enter month of holiday 2");
        holiday h2 = new holiday(A.next(), A.nextInt(), A.next());

        holiday h3 = new holiday();
        System.out.println(h3.inSameMonth(h1, h2));
//part c
        holiday h = new holiday("Independence Day" , 14, "August");
        h.display();

        holiday h5 = h;
        h5.display();
    }
}
