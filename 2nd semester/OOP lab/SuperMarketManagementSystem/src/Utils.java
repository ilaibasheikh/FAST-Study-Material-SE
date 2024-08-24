import java.io.*;
import java.util.ArrayList;


public class Utils {
    public static ArrayList<Item> GetUpdatedItemsFromFile() {
        ArrayList<Item> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String itemName = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                items.add(new Item(itemName, price, quantity));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return items;
    }

    public static void UpdateItemsInFile() {
        try {
            File file = new File("items.txt");
            if (!file.exists()) {
                return;
            }

            try (FileWriter writer = new FileWriter("items.txt", false)) {

                for (Item item : Item.items) {
                    writer.write(item.getName() + "," + item.getAvailableQuantity() + "," + item.getPrice() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error reading/writing to file: " + e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
