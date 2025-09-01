import java.io.*;
import java.nio.file.*;
import java.util.*;
public class Employee extends Item {

    private String empId;
    private String empName;
    private String empPassword;
    private List<Item> inventory;



    //empty constructor
    public Employee() {
        this.empId = getEmpId() ;
        this.empName = getName() ;
        this.empPassword = getEmpPassword() ;
    }
    public Employee(String empId, String empName, String empPassword) {

        this.empId = empId;
        this.empName = empName;
        this.empPassword = empPassword;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public static void addEmployee(Employee employee) {
        try {
            File file = new File("employees.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(employee.getEmpId() + "," + employee.getEmpName() + "," + employee.getEmpPassword() + "\n");
            writer.close();
            // YAHA BHI OUTPUT DENGY KY XYZ HAS BEEN ADDED KRKY
        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
    }
    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            File file = new File("employees.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                Employee employee = new Employee(parts[0], parts[1], parts[2]);
                employees.add(employee);
                // yaha pr print bhi krwana hoga saray employees
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading from file");
            e.printStackTrace();
        }
        return employees;
    }

//    public Employee(String username, String password, String name,Inventory inventory) {
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.inventory = inventory;
//    }

    public static void login() throws IOException {
        String username = null;
        String password = null;
        Scanner inp = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter your username: ");
        username = inp.next();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter password: ");
        password = inp.next();


        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            boolean isValidUser = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String customerId = data[0].trim();
                String customerPassword = data[1].trim();
                if (customerId.equals(username) && customerPassword.equals(password)) {
                    isValidUser = true;
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAuthentication successful!");
                    break;
                }
            }

            if (!isValidUser) {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInvalid username or password.");
                login();
            }

        } catch (IOException e) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tError reading customer data from file.");
        }
    }

    // CRUD methods
    public void addItem() {
        Scanner input = new Scanner(System.in);

        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter item name: ");
        String name = input.nextLine();

        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter item quantity: ");
        int quantity = input.nextInt();
        input.nextLine(); // consume newline

        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter item price: ");
        double price = input.nextDouble();
        input.nextLine();

        String itemData = name + "," + quantity + "," + price + "\n";

        try {
            if (!Files.exists(Path.of("items.txt"))) {
                Files.createFile(Path.of("items.txt"));
            }

            Files.write(Path.of("items.txt"), itemData.getBytes(), StandardOpenOption.APPEND);
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }
    public void updateItem() {
        Scanner input = new Scanner(System.in);

        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter item name: ");
        String name = input.nextLine();

        List<Item> updatedItems = new ArrayList<>();
        boolean found = false;

        try {
            File file = new File("items.txt");
            if (!file.exists()) {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem database is empty.");
                return;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String itemName = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);

                if (itemName.equals(name)) {
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter new quantity: ");
                    quantity = input.nextInt();
                    input.nextLine();

                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter new price: ");
                    price = input.nextDouble();
                    input.nextLine();

                    found = true;
                }

                Item item = new Item(itemName, price, quantity);
                updatedItems.add(item);
            }
            scanner.close();

            if (found) {
                FileWriter writer = new FileWriter("items.txt", false);
                for (Item item : updatedItems) {
                    writer.write(item.getName() + "," + item.getAvailableQuantity() + "," + item.getPrice() + "\n");
                }
                writer.close();
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem updated successfully.");
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading/writing to file: " + e.getMessage());
        }
    }
    public void deleteItem() {
        Scanner input = new Scanner(System.in);

        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter item name: ");
        String name = input.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("items.txt.tmp"))) {

            boolean found = false;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(name)) {
                    found = true;
                    continue; // Skip the current line to delete the item
                }
                writer.write(line);
                writer.newLine();
            }

            reader.close(); // Close the reader before writing to the file

            if (found) {
                writer.close(); // Close the writer before moving the file
                Files.move(Paths.get("items.txt.tmp"), Paths.get("items.txt"), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem deleted successfully.");
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem not found.");
                Files.deleteIfExists(Paths.get("items.txt.tmp"));
            }

        } catch (IOException e) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tError: " + e.getMessage());
        }
    }


    public void displayInventory() {
        System.out.println("\n");
        System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t%-20s %-10s %-10s\n", "Item", "Quantity", "Price");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t%-20s %-10d $%.2f\n", name, quantity, price);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }




    // DISPLAY MENU - EMPLOYEE
    public static void updateInventory() {
        Employee employee = new Employee();
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*************** M E N U **************");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 1. Add item to inventory");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 2. Update item in inventory");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 3. Delete item from inventory");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 4. Display inventory");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 5. Exit");
            System.out.print("\n");
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter your choice: ");
            choice = input.next();
            input.nextLine(); // consume newline

            switch (choice) {
                case "1":
                    employee.addItem();
                    updateInventory();
                    break;
                case "2":
                    employee.displayInventory();
                    employee.updateItem();
                    updateInventory();
                    break;
                case "3":
                    employee.displayInventory();
                    employee.deleteItem();
                    updateInventory();
                    break;
                case "4":
                    employee.displayInventory();
                    updateInventory();
                    break;
                case "5":
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tYou have exited the system!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInvalid choice. Try again.");
            }
        } while (choice != "5");
    }

    // FIND ITEM
    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}