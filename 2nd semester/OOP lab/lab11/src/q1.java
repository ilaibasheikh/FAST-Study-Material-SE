import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) throws IOException {
        ArrayList<Object> array = new ArrayList<>();
        File f1  = new File("filing.txt");

        try {
            if (f1.createNewFile()) {
                System.out.println("File Created Successfully");
            }
        }
        catch (IOException e){
            System.out.println("Error");
        }
        System.out.println("enter elements in array");
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            Object temp;
            temp = inp.next();
            array.add(temp);
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(f1);
            fileWriter.write(String.valueOf(array));
            System.out.println("Done");
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
