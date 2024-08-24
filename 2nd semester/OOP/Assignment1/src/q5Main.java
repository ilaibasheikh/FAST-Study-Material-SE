import java.util.Scanner;
public class q5Main{
public static void main(String[]args){
    Scanner A = new Scanner(System.in);
    int i = 0;
            int[] userID= new int[2];
        System.out.println("Laiba Fatima 22K-5195");
    System.out.println("Enter user id");
    int[] userId = { A.nextInt(), A.nextInt() };
    A.nextLine();
    System.out.println("Enter name");
    String name = A.nextLine();
    System.out.println("Enter age");
    int age = A.nextInt();
    System.out.println("Enter height");
    double height = A.nextDouble();
    System.out.println("Enter gender M/F ");
    String gender = A.next();

    System.out.println("Enter shoe size");
    int shoeSize = A.nextInt();

    User user = new User(userId, name, age, height, gender, shoeSize);

    A.nextLine();
    System.out.print("Enter the shoe width (narrow/regular/wide): ");
    String shoeWidth = A.nextLine();
    System.out.print("Enter the shoe style (running/sneakers/stiletto): ");
    String shoeStyle = A.nextLine();
    System.out.print("Enter the shoe brand: ");
    String shoeBrand = A.nextLine();
    System.out.print("Enter the shoe color: ");
    String shoeColor = A.nextLine();


    Shoe shoe = new Shoe(shoeSize, shoeWidth, shoeStyle, shoeBrand, shoeColor, user.getDemographic());
        shoe.displayShoeInfo(shoe);
        }
}
class User {
    private int[] userId;
    private String name;
    private int age;
    private double height;
    private String gender;
    private int shoeSize;

    public User( ) {
        this.userId = new int[2];
        this.name = "";
        this.age = 0;
        this.height = 0.0;
        this.gender = "";
        this.shoeSize = 0;
    }
    public User(int[] userId, String name, int age, double height, String gender, int shoeSize) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.shoeSize = shoeSize;
    }

    public int[] getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setUserId(int[] userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }
    public String getDemographic() {
        if (age <= 2) {
            return "infant";
        } else if (age >= 3 && age <= 5) {
            return "toddler";
        } else if (age >= 10 && age <= 12) {
            return "child";
        } else if (age >= 13 && age <= 19) {
            return "teenager";
        } else {
            return "adult";
        }
    }

}

class Shoe {
    private int size;
    private String width;
    private String style;
    private String brand;
    private String color;
    private String Demographic;

    public Shoe() {
        size = 0;
        width = "";
        style = "";
        brand = "";
        color = "";
        Demographic = "";
    }

    public Shoe(int size, String width, String style, String brand, String color, String demographic) {
        this.size = size;
        this.width = width;
        this.style = style;
        this.brand = brand;
        this.color = color;
        this.Demographic = demographic;
    }

    public int getSize() {
        return size;
    }

    public String getWidth() {
        return width;
    }

    public String getStyle() {
        return style;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getDemographic() {
        return Demographic;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDemographic(int age) {
        if (age >= 0 && age <= 2) {
            Demographic = "infant";
        } else if (age >= 3 && age <= 5) {
            Demographic = "toddler";
        } else if (age >= 10 && age <= 12) {
            Demographic = "child";
        } else if (age >= 13 && age <= 19) {
            Demographic = "teenager";
        } else {
            Demographic = "adult";
        }
    }
    public void displayShoeInfo(Shoe shoe) {
        System.out.println("Size: " + shoe.getSize());
        System.out.println("Width: " + shoe.getWidth());
        System.out.println("Style: " + shoe.getStyle());
        System.out.println("Brand: " + shoe.getBrand());
        System.out.println("Color: " + shoe.getColor());
        System.out.println("Demographic: " + shoe.getDemographic());
    }


}
