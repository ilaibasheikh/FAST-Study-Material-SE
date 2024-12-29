package fileHandlingandStreams;

import java.io.*;

public class FileHandlingMoreMethods {
    public static void main(String[] args) {
        // Create a directory and some files
        File directory = new File("C:\\Users\\NazMemon\\eclipse-workspace\\Practice");
        File file1 = new File("C:\\Users\\NazMemon\\eclipse-workspace\\Practice\\src\\hello.txt");
        File file2 = new File("C:\\Users\\NazMemon\\eclipse-workspace\\Practice\\src\\masurcaRun.txt");

        // Create the directory if it doesn't exist
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Schedule file1 for deletion on JVM exit
        file1.deleteOnExit();

        // List files in the directory
        File[] files = directory.listFiles();
        System.out.println("Files in the directory:");
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Get the absolute path of file2
        String absolutePath = file2.getAbsolutePath();
        System.out.println("Absolute Path of file2: " + absolutePath);

        // Set file2 to be readable
        boolean setReadableSuccess = file2.setReadable(true);
        System.out.println("Is file2 readable now? " + setReadableSuccess);

        // Set file2 to be read-only
        boolean setReadOnlySuccess = file2.setReadOnly();
        System.out.println("Is file2 read-only now? " + setReadOnlySuccess);
        
     // Set file2 to be writeable
       // boolean setWriteable = file2.setWritable(true); // false makes the file read-only
       // System.out.println("Is file2 Writeable now? " + setWriteable);

        // Check if file2 is hidden
        boolean isHidden = file2.isHidden();
        System.out.println("Is file2 hidden? " + isHidden);

        // Get the parent directory of file2
        File parentDirectory = file2.getParentFile();
        System.out.println("Parent Directory of file2: " + parentDirectory.getAbsolutePath());
    }
}
