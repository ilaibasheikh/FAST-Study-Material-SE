
import java.io.*;
import java.net.*;

public class FileTransferHandler {
    public static void sendFile(File file, String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        dos.writeUTF(file.getName());
        dos.writeLong(file.length());

        byte[] buffer = new byte[4096];
        FileInputStream fis = new FileInputStream(file);
        int count;
        while ((count = fis.read(buffer)) > 0) {
            dos.write(buffer, 0, count);
        }

        fis.close();
        dos.close();
        socket.close();
    }
}
