import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);


        String[] names = new String[7];

        for (int i = 0; i < 6; i++) {
            System.out.print("Enter the name of 6 fruits" );
            names[i] = a.nextLine();
        }

        System.out.print("Enter the name of 1 person: ");
        names[6] = a.nextLine();

        System.out.println("Original array:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ,");
        }

        names[6] = "orange";

        System.out.println();
        System.out.println("Updated array:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ,");
        }
    }
}
