//22k-5195 Laiba Fatima
import java.util.Scanner;

//Class diagram is in the Word document
class Juice{
    private int price;
    private String ingredients;
    private String taste;
    public static int countjuice = 0; //tracking number of objects created

    public Juice(){}
    public Juice(int price, String ingredients, String taste) {
        this.price = price;
        this.ingredients = ingredients;
        this.taste = taste;
        countjuice++;
    }

    public static int getCountjuice() {
        return countjuice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public void print(){
        System.out.println("22K-5195 Laiba also likes juice");
        System.out.println("Price: " + price);
        System.out.println("Ingredients: "+ingredients);
        System.out.println("Taste: " +taste);
    }

}
class FruitJuice extends Juice {
    private String season;
    public static int countfruit= 0;

    public FruitJuice(int price, String ingredients, String taste, String season) {
        super(price, ingredients, taste);
        this.season = season;
        countfruit++;
    }

    public static int getCountfruit() {
        return countfruit;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes fruit juice");
        System.out.println("Season: " +season);
    }
}
class VegetableJuice extends Juice{
    private String origin;

    public VegetableJuice(int price, String ingredient, String taste, String origin) {
        super(price, ingredient, taste);
        this.origin = origin;

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes vegetable juice");
        System.out.println("Origin: " +origin);
    }
}
class MixedJuice extends Juice{


    public MixedJuice(int price, String ingredient, String taste) {
        super(price, ingredient, taste);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes mixed juice");
    }
}
class CitrusJuice extends FruitJuice{

    public CitrusJuice(int price, String ingredients, String taste, String season) {
        super(price, ingredients, taste, season);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes citrus fruit juice");
    }
}
class BerryJuice extends FruitJuice{

    public BerryJuice(int price, String ingredients, String taste, String season) {
        super(price, ingredients, taste, season);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes berry fruit juice");
    }
}
class TropicalJuice extends FruitJuice{
    public TropicalJuice(int price, String ingredients, String taste, String season) {
        super(price, ingredients, taste, season);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes tropical juice");
    }
}
class LeafyGreenJuice extends VegetableJuice{
    public LeafyGreenJuice(int price, String ingredient, String taste, String origin) {
        super(price, ingredient, taste, origin);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes leafy green vegetable juice");
    }
}
class RootVegetableJuice extends VegetableJuice{

    public RootVegetableJuice(int price, String ingredient, String taste, String origin) {
        super(price, ingredient, taste, origin);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes root vegetable juice");
    }
}
class MixedVegetableJuice extends VegetableJuice{

    public MixedVegetableJuice(int price, String ingredient, String taste, String origin) {
        super(price, ingredient, taste, origin);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes mixed vegetable juice");
    }
}
class FruitAndVeggieJuice extends MixedJuice{

    public FruitAndVeggieJuice(int price, String ingredient, String taste) {
        super(price, ingredient, taste);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes fruit and vegetable mixed juice");
    }
}
class SmoothieJuice extends MixedJuice{

    public SmoothieJuice(int price, String ingredient, String taste) {
        super(price, ingredient, taste);
    }

    public void print() {
        super.print();
        System.out.println("22K-5195 Laiba also likes smoothie mixed juice");
    }
}
class Sale extends Juice{
    private String saleID;
    private String CustomerName;
    public static int totalbill;
    private int numberOfFruitJuice;
    private int numberOfVegetableJuice;
    private int numberOfMixedJuice;


    public Sale(String id, String name, int bill, int fruitno, int vegno, int mixno) {
        this.saleID = id;
        this.CustomerName = name;
        this.totalbill = bill;
        this.numberOfFruitJuice = fruitno;
        this.numberOfVegetableJuice = vegno;
        this.numberOfMixedJuice = mixno;
    }

    public static float totalbill() {

        return totalbill;
    }

    public String getSaleID() {
        return saleID;
    }

    public void setSaleID(String id) {
        this.saleID = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String name) {
        CustomerName = name;
    }

    public int getTotalbill() {
        return totalbill;
    }

    public void setTotalbill(int bill) {
        this.totalbill = bill;
    }

    public int getNumberOfFruitJuice() {
        return numberOfFruitJuice;
    }

    public void setNumberOfFruitJuice(int fruitno) {
        this.numberOfFruitJuice = fruitno;
    }

    public int getNumberOfVegetableJuice() {
        return numberOfVegetableJuice;
    }

    public void setNumberOfVegetableJuice(int vegno) {
        this.numberOfVegetableJuice = vegno;
    }

    public int getNumberOfMixedJuice() {
        return numberOfMixedJuice;
    }

    public void setNumberOfMixedJuice(int mixno) {
        this.numberOfMixedJuice = mixno;
    }

    public void print() {
        System.out.println("Sale ID: " + saleID);
        System.out.println("Customer Name: " + CustomerName);
        System.out.println("Total Bill: $" + totalbill);
        System.out.println("Number of Fruit Juices: " + numberOfFruitJuice);
        System.out.println("Number of Vegetable Juices: " + numberOfVegetableJuice);
        System.out.println("Number of Mixed Juices: " + numberOfMixedJuice);
    }

    public static Sale sum(Sale ob1, Sale ob2) {
        if (ob1.getCustomerName().equals(ob2.getCustomerName())) {
            String saleID =  ob1.getSaleID() + " " + ob2.getSaleID();
            String customerName = ob1.getCustomerName();
            int totalBill = ob1.getTotalbill() + ob2.getTotalbill();
            int numberOfFruitJuice = ob1.getNumberOfFruitJuice() + ob2.getNumberOfFruitJuice();
            int numberOfVegetableJuice = ob1.getNumberOfVegetableJuice() + ob2.getNumberOfVegetableJuice();
            int numberOfMixedJuice = ob1.getNumberOfMixedJuice() + ob2.getNumberOfMixedJuice();
            Sale ob3 = new Sale(saleID, customerName, totalbill, numberOfFruitJuice, numberOfVegetableJuice, numberOfMixedJuice);
            return ob3;
        } else {
            System.out.println("Error: Different customer names.");
            return null;
        }

    }
}
public class A2_Q1_22k5195 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("22k-5195 Laiba Fatima");
        System.out.println("Welcome to the Juice Shop!");
        System.out.println("What is your name?");

        String name = a.next();

        do {
            System.out.println("**********************************");
            System.out.println("Menu: ");
            System.out.println("1. Fruit Juice");
            System.out.println("2. Vegetable Juice");
            System.out.println("3. Mixed Juice");
            System.out.println("4. Checkout");
            System.out.println("Select an option: ");
            int choice = a.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Citrus Juice");
                    System.out.println("2. Berry Juice");
                    System.out.println("3. Tropical Juice");
                    System.out.println("Select what kind:");
                    int select = a.nextInt();
                    switch (select){
                        case 1:
                            CitrusJuice c = new CitrusJuice(399,"oranges, lemons, and grapefruits","sweet and tangy", "Summer");
                            c.print();
                            break;
                        case 2:
                            BerryJuice b = new BerryJuice(100,"strawberry","sour", "Winter");
                            b.print();
                            break;
                        case 3:
                            TropicalJuice t = new TropicalJuice(200,"Coconut", "Sweet", "Summer");
                            t.print();
                            break;
                        default:
                            System.out.println("Enter valid selection");
                    }
                    break;
                case 2:
                    System.out.println("1. Leafy Green Juice");
                    System.out.println("2. Root Vegetable Juice");
                    System.out.println("3. Mixed Vegetable Juice");
                    System.out.println("Select what kind:");
                    select = a.nextInt();
                    switch (select){
                        case 1:
                            LeafyGreenJuice l = new LeafyGreenJuice(499,"kale, spinach, and celery", "bitter and earthy", "Pak");
                            l.print();
                            break;
                        case 2:
                            RootVegetableJuice r = new RootVegetableJuice(100,"root beer","bitter", "India");
                            r.print();
                            break;
                        case 3:
                            MixedVegetableJuice m = new MixedVegetableJuice(200,"all the veggies", "bitter", "UK");
                            m.print();
                            break;
                        default:
                            System.out.println("Enter valid selection");
                    }
                    break;
                case 3:
                    System.out.println("1. Fruit and Veggie Juice");
                    System.out.println("2. Smoothie Juice");
                    System.out.println("Select what kind:");
                    select = a.nextInt();
                    switch (select){
                        case 1:
                            FruitAndVeggieJuice f = new FruitAndVeggieJuice(100, "Orange and spinach", "Fresh");
                            f.print();
                            break;
                        case 2:
                            SmoothieJuice s = new SmoothieJuice(100,"strawberry, lemon, apple","Sweet");
                            s.print();
                            break;
                        default:
                            System.out.println("Enter valid selection");
                    }

                    break;
                case 4:
                    float bill;
                    bill= Sale.totalbill();
                    System.out.println("Total bill: "+bill);

                    System.out.println("Thank you for shopping with us! " );
                    //implementation of d part
                    Sale sale1 = new Sale("1001", "Laiba", 399, 1, 1, 1);
                    Sale sale2 = new Sale("1002", name, 499, 2, 1, 0);

                    // Sum two sales objects
                    Sale sumSale = Sale.sum(sale1, sale2);
                    if (sumSale != null) {
                        sumSale.print();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        } while (true);

        }
}
