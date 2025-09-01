import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner a=new Scanner(System.in);
        String c;
        String s;
        float price=0.0f;
        float discountper=0.0f;
        float discount=0.0f;
        float btax=0.0f;
        float stax=0.0f;
        float itemp=0.0f;
        float total=0.0f;
        float subtotal=0.0f;
        do{
            System.out.println("Enter item name: ");
            Scanner A= new Scanner(System.in);
            s=A.next();
            System.out.println("Enter item price: ");
            Scanner B= new Scanner(System.in);
            price=B.nextFloat();

            System.out.println("Do you want to continue? ");
            c=A.next();
        }
        while(c.equals("Y") || c.equals("y") );
        System.out.println("Enter discount percent: ");
        Scanner C= new Scanner(System.in);
        discountper=C.nextFloat();
        discount=discountper*price;
        btax=price+total;
        System.out.println("Enter sales tax: ");
        stax=C.nextFloat();
        itemp=price-discount+stax;
        total=total+itemp;
        subtotal=subtotal+price;

        System.out.println("Invoice: ");
        System.out.println("Subtotal: "+subtotal);
        System.out.println("discount percent: "+discountper);
        System.out.println("discount amount: "+discount);
        System.out.println("before tax: "+btax);
        System.out.println("sales tax: "+stax);
        System.out.println("invoice total: "+total);
    }
}