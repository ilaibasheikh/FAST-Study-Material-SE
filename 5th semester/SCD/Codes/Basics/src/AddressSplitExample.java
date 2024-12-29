public class AddressSplitExample {
    public static void main(String[] args) {
        // Given address
        String address = "banglow no 326, Block A, Sector 30, DHA, Karachi";

        // Split the address using ","
        String[] parts = address.split(",");

        // Ensure there are at least four parts
        if (parts.length >= 4) {
            // Extract the house no, block, area, and city
            String houseNo = parts[0].trim();
            String block = parts[1].trim();
            String area = parts[2].trim();
            String city = parts[3].trim();

            // Print the extracted parts
            System.out.println("House No: " + houseNo);
            System.out.println("Block: " + block);
            System.out.println("Area: " + area);
            System.out.println("City: " + city);
        } else {   
            System.out.println("Invalid address format.");
        }
    }
}
