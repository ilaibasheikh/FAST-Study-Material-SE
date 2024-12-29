package fileHandlingandStreams;
import java.io.File;
import java.io.IOException;

public class FileManipulationExample {
    public static void main(String[] args) {
        // Create a new File object
        File file = new File("C:\\\\Users\\\\NazMemon\\\\eclipse-workspace\\\\Practice\\\\src\\\\Hello.txt");

        try {
            // Create a new empty file
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("File created successfully.");
            }

            // Get and display file properties
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Length (in bytes): " + file.length());
            System.out.println("Can Read: " + file.canRead());
            System.out.println("Can Write: " + file.canWrite());
            System.out.println("File Exists: " + file.exists());

            // List files in the directory
            String[] fileList = file.getParentFile().list();
            System.out.println("Files in the directory:");
            for (String fileName : fileList) {
                System.out.println(fileName);
            }

            // Delete the file
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("File deletion failed.");
            }

            // Check if the file exists after deletion
            System.out.println("File Exists: " + file.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
