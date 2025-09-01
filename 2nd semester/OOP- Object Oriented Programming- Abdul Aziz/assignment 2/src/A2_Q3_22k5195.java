//22k-5195 Laiba Fatima
abstract class Product {
    protected String name;
    protected double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double getDiscountedPrice();

    public abstract void printDetails();
    public Product() {

    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Product add(Product p1, Product p2){
        //applying this function for Book class
        Product p3=new Book();
        p3.price=(p1.price+p2.price)/2;
        p3.name=p1.name+" & "+p2.name;
        return(p3);
    }
}
class Book extends Product{
    public String author;
    public double getDiscountedPrice() {
        return price * 0.9 ;
    }

    public Book() {

    }

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public void printDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Discounted Price: " + getDiscountedPrice());
    }

}
class Electronic extends Product{
    private String brand;
    public double getDiscountedPrice() {

        return price * 0.35;
    }
    public Electronic(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void printDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Discounted Price: " + getDiscountedPrice());
    }

}
class Clothing extends Product{
    private String size;
    public double getDiscountedPrice() {
        return price *0.15 ;
    }
    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }
    @Override
    public void printDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Size: " + size);
        System.out.println("Price: " + price);
        System.out.println("Discounted Price: " + getDiscountedPrice());
    }

}
interface Customer{
     String name = "22k-5195";
     double balance = 0;
     abstract public void buyProduct(Product p);
     abstract void printDetails();
}
class Customer1 implements Customer{
    String name ;
    double balance ;

    public Customer1(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void buyProduct(Product p){
        double discount = p.getDiscountedPrice();
        if (balance>discount){
            balance -= discount;
            System.out.println(name + "  has bought the product: " + p.name);
        }
        else{
            System.out.println(name + "  can't buy the product: " + p.name);
        }
    }
    public void printDetails() {
        System.out.println("Name : " + name);
        System.out.println("Balance : $" + balance);
    }
}
interface VIPCustomer extends Customer {
    @Override
     default void buyProduct(Product product) {
        double discountedPrice = product.getDiscountedPrice();
        double additionalDiscount = 0.1 * discountedPrice;
        discountedPrice -= additionalDiscount;

        if (balance >= discountedPrice) {

            System.out.println(name + " (VIP) has bought the product: " + product.name);
        }
        else {
            System.out.println(name + " (VIP) does not have enough balance to buy the product: " + product.name);
        }
    }

}
class VIPCustomerImpl implements VIPCustomer {
    private String name;
    private double balance;

    public VIPCustomerImpl(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void buyProduct(Product product) {
        double discountedPrice = product.getDiscountedPrice() * 0.9; // 10% additional discount for VIP customers
        if (balance >= discountedPrice) {
            balance -= discountedPrice;
            System.out.println(name + " (VIP) has bought " + product.name + " for $" + discountedPrice);
        } else {
            System.out.println(name + " (VIP) does not have enough balance to buy " + product.name);
        }
    }

    public void printDetails() {
        System.out.println("VIP Customer Name: " + name);
        System.out.println("Balance: $" + balance);
    }
}

public class A2_Q3_22k5195 {
    public static void main(String[] args) {
        System.out.println("22k-5195 Laiba Fatima");
        Product book = new Book("Alchemist", 790.99, "Paul");
        Product electronic = new Electronic("J7 Prime", 100.0, "Samsung");
        Product clothing = new Clothing("Dress", 98.0, "4");

       Customer customer1 = new Customer1("Laiba",987.0 );

        System.out.println("Customer1 details:");

        customer1.buyProduct(book);

        customer1.buyProduct(electronic);

        customer1.buyProduct(clothing);
        customer1.printDetails();

        Customer customer2 = new Customer1("fatima", 100.0);
        System.out.println("\nCustomer2 details:");

        customer2.buyProduct(book);

        customer2.buyProduct(electronic);

        customer2.buyProduct(clothing);
        customer2.printDetails();

        System.out.println("\nVIP: ");
        VIPCustomer vipCustomer1 = new VIPCustomerImpl("noor", 200);
        vipCustomer1.buyProduct(book);
        vipCustomer1.buyProduct(electronic);
        vipCustomer1.buyProduct(clothing);
        vipCustomer1.printDetails();

        System.out.println("\nProduct details: ");

       book.printDetails();
        electronic.printDetails();
      clothing.printDetails();



        //part b
        System.out.println("\nAverage price");
        Product p1 = new Book("Harry Potter", 40.6, "Laiba" );
        Product p2 = new Book("Philosopher's Stone", 98.6, "Fatima" );
        Product p3 = new Book() ;
        p3.add(p1,p2);
        System.out.println(p3.getName());
        System.out.println(p3.getPrice());


  }
}

