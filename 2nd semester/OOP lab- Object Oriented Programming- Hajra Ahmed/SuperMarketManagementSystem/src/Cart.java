import java.util.ArrayList;

public class Cart {
    static ArrayList<Cart> itemsCart = new ArrayList<>();
    private String name;
    private String quant;

    public Cart(){
        this.name = "";
        this.quant= "";
    }

    public Cart(String name, String quantity) {
        this.name=name;
        this.quant = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quant;
    }

    public void setQuantity(String quantity) {
        this.quant = quantity;
    }
}
