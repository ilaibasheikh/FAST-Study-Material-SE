package fileHandlingandStreams;

import java.io.File;
import java.io.IOException;

public class HandlingTwo {
    public static void main(String[] args) {
        // Create a new file
        try {
            File newFile = new File("C:\\Users\\NazMemon\\eclipse-workspace\\Practice\\src\\FileHandling\\newFile.txt");
            
            if (newFile.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        // Rename the file
        File oldFile = new File("newFile.txt");
        File renamedFile = new File("renamedFile.txt");
        
        if (oldFile.renameTo(renamedFile)) {
            System.out.println("File renamed successfully!");
        } else {
            System.out.println("File renaming failed.");
        }

        // Check if a file exists
        File checkFile = new File("renamedFile.txt");
        
        if (checkFile.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }

        // Get file size
        long fileSize = checkFile.length();
        System.out.println("File size: " + fileSize + " bytes");

        // Delete the file
        if (checkFile.delete()) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("File deletion failed.");
        }
    }
}

