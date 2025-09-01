import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    public static void main(String[] args) {
        try {
            // Attempt to read a file
            String filePath = "example.txt";
            String content = readFile(filePath);
            System.out.println("File content is here: " + content);
        } catch (CustomFileException cfe) {
            System.err.println("Custom File Exception: " + cfe.getMessage());
        } catch (IOException io) {
            System.err.println("IO Exception: " + io.getMessage());
        } finally {
            System.out.println("File processing completed.");
        }
    }

    public static String readFile(String filePath) throws CustomFileException, IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException io) {
            throw new CustomFileException("Error reading the file: " + io.getMessage(), io);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file: " + e.getMessage());
                }
            }
        }
    }
}

class CustomFileException extends Exception {
    public CustomFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
