import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define snack categories and their respective prices
        double chipsPrice = 30.0;
        double friesPrice = 50.0;
        double samosaPrice = 20.0;

        double chocolatePrice = 100.0;
        double gulabJamunPrice = 50.0;
        double cakePrice = 500.0;

        double chilliBitesPrice = 400.0;
        double soupPrice = 300.0;
        double dynamiteWingsPrice = 500.0;

        // Display the menu in tabular form
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("================================");
        System.out.println("Category\t\tSnack\t\tPrice ($)");
        System.out.println("--------------------------------");
        System.out.println("Salty\t\t\tChips\t\t" + chipsPrice);
        System.out.println("\t\t\tFries\t\t" + friesPrice);
        System.out.println("\t\t\tSamosa\t\t" + samosaPrice);
        System.out.println("--------------------------------");
        System.out.println("Sweet\t\t\tChocolate\t" + chocolatePrice);
        System.out.println("\t\t\tGulab-Jamun\t" + gulabJamunPrice);
        System.out.println("\t\t\tCake\t\t" + cakePrice);
        System.out.println("--------------------------------");
        System.out.println("Sour\t\t\tChilli Bites\t" + chilliBitesPrice);
        System.out.println("\t\t\tSoup\t\t" + soupPrice);
        System.out.println("\t\t\tDynamite Wings\t" + dynamiteWingsPrice);
        System.out.println("================================");

        System.out.print("Enter your choice (e.g., 1 for Chips): ");
        int choice = scanner.nextInt();
        double selectedPrice = 0;

        // Determine the selected snack and its price
        switch (choice) {
            case 1:
                selectedPrice = chipsPrice;
                break;
            case 2:
                selectedPrice = friesPrice;
                break;
            case 3:
                selectedPrice = samosaPrice;
                break;
            case 4:
                selectedPrice = chocolatePrice;
                break;
            case 5:
                selectedPrice = gulabJamunPrice;
                break;
            case 6:
                selectedPrice = cakePrice;
                break;
            case 7:
                selectedPrice = chilliBitesPrice;
                break;
            case 8:
                selectedPrice = soupPrice;
                break;
            case 9:
                selectedPrice = dynamiteWingsPrice;
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                scanner.close();
                return;
        }

        // Ask the user to enter coins
        System.out.print("Enter coins (in dollars): ");
        double coins = scanner.nextDouble();

        // Check if the user's coins match the price
        if (coins == selectedPrice) {
            System.out.println("Enjoy your snack! Thank you for using the vending machine.");
        } else if (coins < selectedPrice) {
            System.out.println("Insufficient funds. Please insert more coins.");
        } else {
            // Calculate and return change
            double change = coins - selectedPrice;
            System.out.println("Enjoy your snack! Your change is $" + change);
        }

        scanner.close();
    }
}
