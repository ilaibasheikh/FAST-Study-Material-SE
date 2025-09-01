import java.sql.SQLOutput;
import java.util.Scanner;

public class q1 {
    public String purchase[]=new String[3];
    Scanner a=new Scanner(System.in);
    public void Input(int size){
        System.out.println("Enter the purchase item");
        int i=0;
        for(i=0;i<size;i++){
            purchase[i]=a.nextLine();
        }
    }
    public void display(int size){
        int i=0;
        for(i=0;i<size;i++) {
            System.out.println(purchase[i]);
        }
    }
    public static void main(String[] args){
        Scanner a=new Scanner(System.in);
        System.out.println("Enter number of purchases");
        int size=a.nextInt();
        q1 ob=new q1();
        ob.Input(size);
        ob.display(size);

    }
}
