import java.util.*;
class Item {

    public  static ArrayList<Item> items = new ArrayList<>();
    private String name;
    private double price;
    private int availableQuantity;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.availableQuantity = quantity;
    }
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item() {
        this.items.clear();
        this.items = Utils.GetUpdatedItemsFromFile();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;

    }}