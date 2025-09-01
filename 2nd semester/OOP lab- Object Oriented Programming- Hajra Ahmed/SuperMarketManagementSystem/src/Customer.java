import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Customer extends Item {
    private static String username;
    private String password;
    private String pastOrdersFile;
    private List<Order> orders;
    private String name;

    public Customer(){
        this.username = getUsername();
        this.password = getPassword();
        this.pastOrdersFile = getPastOrdersFile();
    }

    // Constructor
    public static void login() throws IOException {
        String loginname = null;
        String password = null;

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 1.New Customer" +
                "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 2.Old Customer");
        Scanner inp = new Scanner(System.in);
        String choice = inp.next();
        switch (choice) {
            case "1":
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter your username: ");
                String newCustomerId = inputReader.readLine();
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter password: ");
                String newCustomerPassword = inputReader.readLine();

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt", true))) {
                    writer.write(newCustomerId + "," + newCustomerPassword);
                    writer.newLine();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tYour account has been created!");
                } catch (IOException ex) {
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tError adding new customer!");
                }
                login();
                break;
            case "2":
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter your username: ");
                loginname = inp.next();

                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter password: ");
                password = inp.next();

                try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
                    String line;
                    boolean isValidUser = false;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        String customerId = data[0].trim();
                        String customerPassword = data[1].trim();
                        if (customerId.equals(loginname) && customerPassword.equals(password)) {
                            isValidUser = true;
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAuthorization Successfull");
                            break;
                        }
                    }
                    if (!isValidUser) {
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInvalid username or password.");
                        login();
                    }
                } catch (IOException e) {
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tError reading customer data from file.");
                }
                break;
            default:
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter valid number");
                login();
        }
        username = loginname;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPastOrdersFile() {
        return pastOrdersFile;
    }

    public void setPastOrdersFile(String pastOrdersFile) {
        this.pastOrdersFile = pastOrdersFile;
    }

    //placing order

    public void addToCart() {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAvailable items:");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t Item Name                  Price");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------------------");

        for (Item i : items
        ) {
            System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t%-20s $%8.2f\n", i.getName(), i.getPrice());

        }
        System.out.print("\n");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter the item name you want to choose: ");
        String itemName = inp.next();
        boolean itemFound = false;

        for (Item i : items) {
            if (itemName.equalsIgnoreCase(i.getName())) {
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter the quantity: ");
                String inputQuantity = inp.next();

                if (Integer.parseInt(inputQuantity) <= i.getAvailableQuantity()) {
                    Cart cartItem = new Cart(i.getName(), inputQuantity);
                    Cart.itemsCart.add(cartItem);
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSuccessfully added the item");
                    itemFound = true;
                    break;
                } else {
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tQuantity exceeds available quantity. Please try again.");
                    addToCart();
                    return;
                }
            }
        }

        if (!itemFound) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem not available.");
            addToCart();
        }
        Customer.Menu();
    }
    // these feature will be available at the end after displaying the chosen items
    // customer would have 2 options either proceed to place order OR remove

    public void placeOrder() {
        if (Cart.itemsCart.isEmpty()) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tYour cart is empty. Please add items before placing an order.");
            Customer.Menu();
            return;
        }
        // Calculate the total amount
        double totalAmount = 0;

        ArrayList<Double> amounts = new ArrayList<Double>();
        for (Cart cartitem : Cart.itemsCart) {
            for (Item item : items) {
                if (cartitem.getName().equalsIgnoreCase(item.getName())) {
                    amounts.add(item.getPrice());
                    totalAmount += item.getPrice() * Integer.parseInt(cartitem.getQuantity());
                    item.setAvailableQuantity(item.getAvailableQuantity() - Integer.parseInt(cartitem.getQuantity()));
                    Utils.UpdateItemsInFile();
                }
            }
        }
        // Create the order
        String orderId;
        orderId = generateOrderId();
        Order order = new Order(orderId, totalAmount);

        // Update the customer's past orders
        try {
            addOrder(username, order);
        } catch (IOException e) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tError adding order to the past orders file.");
        }

        // Print the final receipt
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOrder placed successfully. Here is your receipt:");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOrder ID: " + orderId);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItems:");
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t****************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t*                     RECEIPT                      *");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t****************************************************");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Item Name\t\t    Quantity\t\t\tPrice");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t----------------------------------------------------");
        int index = 0;
        for (Cart itemName : Cart.itemsCart) {


            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  " + itemName.getName() + "\t\t\t\t    " + itemName.getQuantity() + "\t\t\t    $" + Integer.parseInt(itemName.getQuantity()) * amounts.get(index));
            index++;
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal Amount: " + totalAmount);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t----------------------------------------------------");

        // Clear the cart
        Cart.itemsCart.clear();
    }

    public void UpdateCart() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCART ITEMS:");
        for (Cart cartItem : Cart.itemsCart) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+cartItem.getName() + " - " + cartItem.getQuantity());
        }

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1. Edit Item Quantity");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2. Remove Item");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t3. Back");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter the name of the item you want to edit: ");
                String itemName = scanner.nextLine();

                boolean itemFound = false;
                for (Cart cartItem : Cart.itemsCart) {
                    if (cartItem.getName().equalsIgnoreCase(itemName)) {
                        itemFound = true;
                        // check available quantity from item.txt file
                        int availableQuantity = 0;
                        for (Item item: items
                        ) {
                            if (item.getName().equalsIgnoreCase(itemName)) {
                                availableQuantity = item.getAvailableQuantity();
                                break;
                            }
                        }

                        if (availableQuantity == 0)
                        {
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem Out Of Stock");
                            UpdateCart();
                            break;
                        }

                        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter the new quantity: ");
                        String newQuantity = scanner.next();
                        scanner.nextLine();
                        if (Integer.parseInt(newQuantity) > 0 && Integer.parseInt(newQuantity) <= availableQuantity) {
                            // If the item is found and the new quantity is within the available range, update the quantity
                            cartItem.setQuantity(newQuantity);
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tQuantity updated.");
                            Customer.Menu();
                            break;
                        } else {
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInvalid quantity. Please try again.");
                            UpdateCart();
                            break;
                        }
                    }
                }
                if (!itemFound) {
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem not found in cart.");
                    UpdateCart();
                }
                break;
            case "2":
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter the name of the item you want to remove: ");
                itemName = scanner.nextLine();
                itemFound = false;
                for (Cart cartItem : Cart.itemsCart) {
                    if (cartItem.getName().equalsIgnoreCase(itemName)) {
                        itemFound = true;
                        // If the item is found, remove it from the cart
                        Cart.itemsCart.remove(cartItem);
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem removed.");
                        for (Cart cartItems : Cart.itemsCart) {
                            System.out.println(cartItems.getName() + " - " + cartItems.getQuantity());
                        }
                        Customer.Menu();
                        break;
                    }
                }
                if (!itemFound) {
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tItem not found in cart.");
                    UpdateCart();
                }
                break;
            case "3" :
                Customer.Menu();
                break;

            default:
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInvalid input. Please try again.");
                UpdateCart();
                break;
        }
    }

    // Method to add a new order to the past orders file
    public void addOrder(String username, Order order) throws IOException {
        String customerFile = username + ".txt";
        BufferedWriter writer = null;
        try {
            // Open the file in append mode
            writer = new BufferedWriter(new FileWriter(customerFile, true));
            // Write the order details to the file
            writer.write("Order ID: " + order.getOrderid() + " - Total Amount: " + order.getTotalAmount());
            writer.newLine();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    // Method to view past orders for a customer
    public void viewPastOrders(String username) throws IOException {
        String customerFile = username + ".txt";
        File file = new File(customerFile);
        if (!file.exists()) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo past records found for the customer.");
            return;
        }

        BufferedReader reader = null;
        try {
            // Open the file in read mode
            reader = new BufferedReader(new FileReader(customerFile));
            String line;
            // Read and print each line of the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public String generateOrderId() {
        // Generate a random 6-digit number
        int randomNum = ThreadLocalRandom.current().nextInt(100000, 1000000);

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time as a string
        String dateTimeString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now);

        // Combine the date/time string and the random number to form the order ID
        String orderId = "ORD-" + dateTimeString + "-" + randomNum;

        return orderId;
    }
    public static void Menu() {
        Customer customer = new Customer();
        Scanner inp = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*************** M E N U **************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1. View Past Orders");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2. Add to cart");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t3. Update Cart");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t4. Place Order");
        String ch = inp.next();
        switch (ch) {
            case "1":
                try {
                    customer.viewPastOrders(customer.getUsername());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Menu();
                break;
            case "2":
                customer.addToCart();
                Menu();
                break;
            case "3":
                customer.UpdateCart();
                Menu();
                break;
            case "4":
                customer.placeOrder();
                Menu();
                break;
            default:
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInvalid input. Please try again.");
                Menu();
                break;
        }
    }
}