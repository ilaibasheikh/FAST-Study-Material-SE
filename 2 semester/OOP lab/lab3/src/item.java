import java.util.Scanner;

public class item {
    public String itemname;
    public int itemid;
    private float itemprice;
    private int itemstock;

    float  getItemprice(){
        return itemprice;
    }
    void setItemprice(float itemprice){
        this.itemprice = itemprice;
    }
    int getItemstock(){
        return itemstock;
    }
    void setItemstock(int itemstock){
        this.itemstock = itemstock;
    }

    public static void main(String[] args) {
        item i1 = new item();

        Scanner A = new Scanner(System.in);
        String name;
        int id;
        float price;
        int stock;

        System.out.println("Enter item name");
        name = A.next();
        i1.itemname = name;
        System.out.println("Enter item id");
        id = A.nextInt();
        i1.itemid = id;
        System.out.println("Enter the price of item");
        price = A.nextFloat();
        float c;
        c= price;
        i1.setItemprice(price);
        System.out.println("Enter stock of item;");
        stock = A.nextInt();
        i1.setItemstock(stock);
        int b;
        b= i1.getItemstock();


        int a;
        float totalbill = 0.0f;
        System.out.println("Enter how many items do you want to purchase");
        a = A.nextInt();

        if (a>b){
            System.out.println("You cant purchase more items than available in stock");
            totalbill = 0.0f;
        }
        else{
            b = b - a;
            totalbill = a * c;
        }
        System.out.println("BILL");
        System.out.println("Total Item price = " +totalbill);
        System.out.println("Items left in stock=" +b);





    }


}