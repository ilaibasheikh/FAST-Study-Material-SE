import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        Employee employee = new Employee();
        Display.display();
        LocalDate today = LocalDate.now();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Date : " + today);
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   WELCOME TO THE SUPERMARKET!\n");
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    LOG IN AS:\n " +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    1.Customer\n " +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    2.Employee");
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Enter 1 OR 2");
        String choice;
        do {
            choice = inp.next();
            if (choice.equalsIgnoreCase("1")) {
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }
                Display.display();
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELCOME CUSTOMER!");
                Customer.login();
                Customer.Menu();
            }
            if (choice.equalsIgnoreCase("2")) {
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }
                Display.display();
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELCOME EMPLOYEE!");
                Employee.login();
                employee.updateInventory();
            }

            if (choice != "1" && choice != "2") {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInvalid input. Please try again.");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter either 1 or 2");
            }

        } while (choice != "1" && choice != "2");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Thank You");
    }
}