import java.util.Scanner;

public class Box {
    int width , height;
    public Box(){
        Scanner scan=new Scanner(System.in);
        do {

            System.out.println("Enter width: ");
            width = scan.nextInt();
            System.out.println("Enter height: ");
            height = scan.nextInt();
        }while (width<0 || height<0);
    }
    public Box(int h) {
        do {
            height = h;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter width: ");
            width = scan.nextInt();
        }while(width<0 || height<0);
    }
    public Box(int w , int h)
    {

        width = w;
        height = h;

    }
    public Box(Box ob){
        do {
            width= ob.width;
            height=ob.height;
        }while(width<0 || height<0);
    }
    void print(){
        System.out.println("Width : "+ width);
        System.out.println("Height : " + height);
        System.out.println("\n");
    }
}
class Mainclass{
    public static void main(String[] args) {
        //part a
        Box b2 =new Box(2,4);
        Box b3=b2;
        b3.print();
        //part b
        Box b4=new Box(5);
        b4.print();
        // part c
        Box b1= new Box();

        System.out.println("Box c: ");
        b1.print();
    }
}

