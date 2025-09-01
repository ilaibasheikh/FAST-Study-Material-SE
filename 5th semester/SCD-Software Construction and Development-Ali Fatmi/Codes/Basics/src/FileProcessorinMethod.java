
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessorinMethod {
    public static void main(String[] args) {
        try {
            String filePath = "example.txt";
            String content = readAndProcessFile(filePath);
            System.out.println("File content: " + content);
        } catch (CustomFileException cfe) {
            System.err.println("Custom File Exception: " + cfe.getMessage());
        } catch (IOException io) {
            System.err.println("IO Exception: " + io.getMessage());
        } finally {
            System.out.println("File processing completed.");
        }
    }

    public static String readAndProcessFile(String filePath) throws CustomFileException, IOException {
        try {
            String content = readFile(filePath);
            // Additional processing on the content if needed
            return content;
        } catch (IOException io) {
            throw new CustomFileException("Error reading the file: " + io.getMessage(), io);
        }
    }

    public static String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }
}

class CustomFileException extends Exception {
    public CustomFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
