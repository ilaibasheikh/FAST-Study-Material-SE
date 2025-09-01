import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class q5 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("Confidential.txt");
        f1.createNewFile();

        System.out.println("enter your designation");
        Scanner inp = new Scanner(System.in);
        String  desig;
        desig = inp.next();

        if (desig.equals("student")) {
            f1.setExecutable(false);
            f1.setReadable(true);
            f1.setWritable(false);
        } else if (desig.equals("faculty")) {
            f1.setWritable(true);
            f1.setReadable(true);
            f1.setExecutable(true);
        }
        System.out.println(f1.canRead());
        System.out.println(f1.canExecute());
        System.out.println(f1.canWrite());
    }
}
