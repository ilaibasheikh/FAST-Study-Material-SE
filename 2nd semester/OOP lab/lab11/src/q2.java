import java.io.*;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("laiba.txt");
        f1.createNewFile();
        try {
            if (f1.createNewFile()) {
                System.out.println("File Created Successfully");
            }
        }
        catch (IOException e){
            System.out.println("Error");
        }
        System.out.println("Enter your Name");
        String name;
        Scanner inp = new Scanner(System.in);
        name = inp.next();
        System.out.println("enter your Qualification");
        String qual;
        qual = inp.next();

        BufferedWriter bw = new BufferedWriter(new FileWriter(f1));

        bw.write(name);
        bw.write("\n");
        bw.write(qual);

        bw.close();
        BufferedReader br = new BufferedReader(new FileReader(f1));
        String buffer;
        while ((buffer  = br.readLine()) != null){
            System.out.println(buffer);
        }
        br.close();
    }
}
