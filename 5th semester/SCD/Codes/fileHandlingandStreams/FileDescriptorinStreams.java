package fileHandlingandStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.io.PrintStream;
import java.util.Scanner;

public class FileDescriptorinStreams {
    public static void main(String[] args) {
        // Using FileDescriptor to access standard input (System.in)
        Scanner scanner = new Scanner(new FileInputStream(FileDescriptor.in));
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);

        // Using FileDescriptor to access standard output (System.out)
        PrintStream printStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        printStream.println("This will be printed to standard output using FileDescriptor.");

        // Using FileDescriptor to access standard error (System.err)
        PrintStream errorStream = new PrintStream(new FileOutputStream(FileDescriptor.err));
        errorStream.println("This will be printed to standard error using FileDescriptor.");
    }
}
