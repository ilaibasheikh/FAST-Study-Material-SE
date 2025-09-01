import java.util.Scanner;
interface MessageService{
    void send(String message,String recipient);
    void recieve();
}
class Whatsapp implements MessageService{
    String message;
    String recipient;
    @Override
    public void send(String message, String recipient)
    {
        this.message=message;
        this.recipient=recipient;
        System.out.println("Message sent");
    }
    @Override
    public void recieve() {
        System.out.println("Message sent to "+recipient);
        System.out.println(message);
    }
}
public class q5 {
    public static void main(String[] args) {
        Scanner A =new Scanner(System.in);
        System.out.println("Enter message: ");
        String message= A.next();
        System.out.println("Enter recipient: ");
        String recipient= A.next();
        Whatsapp w=new Whatsapp();
        w.send(message,recipient);
        w.recieve();
    }
}
