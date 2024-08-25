class Robot{
    int x, y;
    String direction;

    public Robot(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public void display() {
        System.out.println("Current position: (" + x + ", " + y + "), facing " + direction);
    }
}
class moving extends Robot{

    public moving(int x, int y, String direction) {

        super(x, y, direction);
    }

    public void move(int steps){
        switch (direction){
            case "N":
                y += steps;
                break;
            case "S":
                y -= steps;
                break;
            case "E":
                x += steps;
                break;
            case "W":
                x -= steps;
                break;
            default:
                System.out.println("Invalid direction");
        }
    }
    public void display() {

        System.out.println("Updated position: (" + x + ", " + y + "), facing " + direction);
    }
}
public class q3 {

    public static void main(String[] args) {
        Robot r = new Robot(2,4,"N");
        r.display();
        moving robot  = new moving(2,4,"N");
        robot.move(5);
        robot.display();
    }


}
