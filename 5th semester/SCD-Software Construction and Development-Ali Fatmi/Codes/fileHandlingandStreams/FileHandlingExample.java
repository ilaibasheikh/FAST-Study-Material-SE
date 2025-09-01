package fileHandlingandStreams;
import java.io.*;

public class FileHandlingExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\NazMemon\\eclipse-workspace\\Practice\\src\\masurcarun.txt"; // Replace with your file path

        // Example 1: Using read()
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // Assuming it's a text file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example 2: Using read(byte[] array)
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1]; // You can adjust the buffer size
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
            	System.out.print(" ");
            	System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example 3: Using read(byte[] array, int offset, int length)
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int offset = 0;
            int length = 50; // You can adjust the length as needed
            while ((bytesRead = fis.read(buffer, offset, length)) != -1) {
            	System.out.println("-");
                System.out.write(buffer, offset, bytesRead);
                offset += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
