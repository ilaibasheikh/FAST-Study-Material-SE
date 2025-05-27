import java.io.*;
import java.net.*;

public class FileReceiverThread extends Thread {
    private ServerSocket serverSocket;

    public FileReceiverThread(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(() -> receiveFile(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void receiveFile(Socket socket) {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String fileName = dis.readUTF();
            long fileSize = dis.readLong();

            FileOutputStream fos = new FileOutputStream("received_" + fileName);
            byte[] buffer = new byte[4096];

            int read;
            long remaining = fileSize;

            while ((read = dis.read(buffer, 0, (int) Math.min(buffer.length, remaining))) > 0) {
                fos.write(buffer, 0, read);
                remaining -= read;
            }

            fos.close();
            dis.close();
            socket.close();

            System.out.println("Received: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
