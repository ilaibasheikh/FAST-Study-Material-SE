
import java.io.*;
import java.net.*;

public class FileTransferHandler {

  
    public static void sendFile(File file, Socket socket) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             FileInputStream fis = new FileInputStream(file)) {

            dos.writeUTF("FILE");  
            dos.writeUTF(file.getName()); 
            dos.writeLong(file.length()); 

          
            String ownerAddress = socket.getInetAddress().toString() + ":" + socket.getPort();
            FileManager.addFile(file.getName(), ownerAddress);  
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, bytesRead); 
            }

            System.out.println("Sent file: " + file.getName());
        } catch (IOException e) {
            System.err.println("Error sending file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean pingPeer(String host, int port) {
        try (Socket socket = new Socket(host, port);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            dos.writeUTF("PING");  
            return true; 
        } catch (IOException e) {
            return false; 
        }
    }

    
    public static void downloadFile(String fileName, String host, int port) throws IOException {
        System.out.println("Starting download for " + fileName + " from " + host + ":" + port);

        try (Socket socket = new Socket(host, port);  
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

          
            dos.writeUTF("REQUEST_FILE");  
            dos.writeUTF(fileName); 

            long fileSize = dis.readLong();  
            if (fileSize == -1) {
                throw new IOException("File not found on peer.");
            }

            File downloadsDir = new File("downloads");
            if (!downloadsDir.exists()) downloadsDir.mkdirs();  

            
            FileOutputStream fos = new FileOutputStream(new File(downloadsDir, fileName));
            byte[] buffer = new byte[4096];
            long remaining = fileSize;
            int bytesRead;

            
            while ((bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, remaining))) > 0) {
                fos.write(buffer, 0, bytesRead);
                remaining -= bytesRead;
            }

            fos.close();  
            System.out.println("File " + fileName + " downloaded successfully.");

            
            String ownerAddress = host + ":" + port;
            FileManager.addFile(fileName, ownerAddress);  
        }
    }
}