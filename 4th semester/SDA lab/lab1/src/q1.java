import java.util.Scanner;
class Car{
    Scanner a = new Scanner(System.in);
    String name;
    char direction;
    int position ;
    public Car(String name, char direction, int position) {
        this.name = name;
        this.direction = direction;
        this.position = position;
    }
    public void turn(){
        System.out.println("The initial direction of " +this.name+" is: " +direction);
        switch(direction){
            case 'E':
                direction = 'S';
                System.out.println("Now the direction of " +this.name+" is: " +direction);
                break;
            case 'S':
                direction = 'W';
                System.out.println("Now the direction of " +this.name+" is: " +direction);
                break;
            case 'W':
                direction = 'N' ;
                System.out.println("Now the direction of " +this.name+" is: " +direction);
                break;
            case 'N':
                direction= 'E';
                System.out.println("Now the direction of " +this.name+" is: " +direction);
                break;
            default:
                System.out.println("Wrong direction!");
        }
    }
    public void turn(char choice){
        System.out.println("The initial direction of " +this.name+" is: " +direction);
        this.direction = choice;
        System.out.println("Now the direction of " +this.name+" is: " +direction);
    }
    public void move(int distance){
        System.out.println("The initial position of " +this.name+" is: "+this.position);
        this.position =distance;
        System.out.println("Now the position of " +this.name+" is: " +position);
    }
}
public class q1 {
    public static void main(String[] args) {
        Car Toyota = new Car ("Corolla", 'W',0);
        Car Honda = new Car ("Civic", 'N',1);
        Car Hyundai = new Car ("Sonata", 'S',0);

        Toyota.turn();
        Honda.turn('S');
        Hyundai.move(4);
    }
}
