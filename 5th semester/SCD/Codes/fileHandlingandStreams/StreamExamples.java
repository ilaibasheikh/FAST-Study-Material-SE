package fileHandlingandStreams;
import java.io.*;

public class StreamExamples {
    public static void main(String[] args) {
        // Example 1: PipedOutputStream - Writing to a piped stream
        try {
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);

            String data = "Hello, PipedOutputStream!";
            byte[] bytes = data.getBytes();
            pipedOutputStream.write(bytes);

            // Reading from the piped input stream
            int bytesRead;
            byte[] readBuffer = new byte[1024];
            while ((bytesRead = pipedInputStream.read(readBuffer)) != -1) {
                System.out.print(new String(readBuffer, 0, bytesRead));
            }

            pipedOutputStream.close();
            pipedInputStream.close();
            System.out.println("\nData written and read from piped stream successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    
        
    }
}
