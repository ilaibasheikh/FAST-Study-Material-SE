import java.util.ArrayList;
import java.util.Scanner;

public class q3 {
    Scanner a= new Scanner(System.in);
    public ArrayList<String> mylist=new ArrayList<String>();
    public void input(){
        int i;
        String sub;
        System.out.println("Enter 5 Courses Name");
        for(i=0;i<5;i++){
            sub=a.nextLine();
            mylist.add(sub);
        }
    }
    public void display(){
        System.out.println("Now Displaying");
        System.out.println(mylist);
    }
    public void change(String x){
        System.out.println("Changing array list element at the second index");
        mylist.set(1,x);
    }
    public static void main(String[] args){
        String x;
        Scanner a= new Scanner(System.in);
        q3 ob=new q3();
        ob.input();
        ob.display();
        System.out.println("Enter the value to change at the second index");
        x=a.next();
        ob.change(x);
        ob.display();

    }
}

