import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        insertData insertData = new insertData();
        updateData updateData = new updateData();
        DeleteData deleteData = new DeleteData();
        ShowData showData = new ShowData();
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Choose an operation:");
            System.out.println("1. Insert User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Show Users");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("id");
                    int u_id = scanner.nextInt();
                    System.out.println("Name");
                    String u_name = scanner.next();
                    System.out.println("email");
                    String email = scanner.next();
                    System.out.println("add password");
                    String pass= scanner.next();
                    String conf;
                    System.out.println("Confirm Password:");
                    conf = scanner.next();
                    while (true) {

                        if (conf.equals(pass)) {
                            break;
                        } else {
                            System.out.println("Passwords do not match. Please try again.");
                        }
                    }
                    insertData.insertEmployee(u_id,u_name,email,pass,conf);
                    break;
                case 2:
                    System.out.print("Enter the ID of the employee to update:  ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter the new mail: ");
                    String mail = scanner.nextLine();
                    updateData.updateUser(updateId, newName, mail);
                    break;
                case 3:
                    System.out.print("Enter the ID of the user to delete:  ");
                    int deleteId = scanner.nextInt();
                    deleteData.deleteuser(deleteId);
                    break;
                case 4:
                    showData.displayEmployees();
                    break;
                case 5:
                    continueRunning = false;
                default:
                    System.out.println("Invalid choice! Please enter a number  between 1 and 5.");
            }
        }
        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }
}
