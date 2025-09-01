package fileHandlingandStreams;
import java.io.*;

public class FileWrittingExample {
    public static void main(String[] args) {
        String filePath = "C:\\\\Users\\\\NazMemon\\\\eclipse-workspace\\\\Practice\\\\src\\\\masurcarun.txt"; // Replace with your file path

        // Example 1: FileOutputStream - Writing to a file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            String data = "Hello, FileOutputStream!"; // Data to write to the file
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example 2: ObjectOutputStream - Writing objects to a stream
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Creating an example object to write
            MyObject myObject = new MyObject("Example Object", 42);
            
            oos.writeObject(myObject);
            System.out.println("Object written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example 3: ByteArrayOutputStream - Writing an array of bytes
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String text = "Hello, ByteArrayOutputStream!";
        byte[] textBytes = text.getBytes();

        try {
            byteArrayOutputStream.write(textBytes);
            byte[] resultBytes = byteArrayOutputStream.toByteArray();
            System.out.println("ByteArrayOutputStream: " + new String(resultBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Example class for ObjectOutputStream
class MyObject implements Serializable {
    private String name;
    private int value;

    public MyObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
