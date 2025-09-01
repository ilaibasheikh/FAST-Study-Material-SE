import java.util.ArrayList;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        ArrayList<String> Array = new ArrayList<>();
        System.out.println("Enter Number of elements to enter in list ");
        Scanner a = new Scanner(System.in);
        int n = a.nextInt();
        int i = 0;
        double sum = 0;
        double avg=0;
        try{
            System.out.println("Enter elements of the list");
            for (i = 0; i < n; i++) {
                Array.add(a.next());
                try {
                    sum += Integer.parseInt(Array.get(i));
                }catch(NumberFormatException e){
                    System.out.println("Invalid format! ");
                }
            }
            avg=sum/n;
            System.out.println("Average: "+avg);
        } catch(NullPointerException e){
            System.out.println("Null pointer Exception !");
        }
    }
}