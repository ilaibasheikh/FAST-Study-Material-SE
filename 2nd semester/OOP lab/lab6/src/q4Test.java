class Rectangle {
    int length;
    int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void printArea() {
        System.out.println("Area of Rectangle: " + length * breadth);
    }

    void printPerimeter() {
        System.out.println("Perimeter of Rectangle: " + 2 * (length + breadth));
    }
}

class Square extends Rectangle {
    int side;

    Square(int side) {
        super(side, side);
        this.side = side;
    }

//    void printArea() {
//        System.out.println("Area of Square: " + side * side);
//    }
//
//    void printPerimeter() {
//        System.out.println("Perimeter of Square: " + 4 * side);
//    }
}

public class q4Test {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 10);
        r.printArea();
        r.printPerimeter();

        Square s = new Square(7);
        s.printArea();
        s.printPerimeter();
    }
}