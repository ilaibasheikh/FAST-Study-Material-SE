import java.io.*;
import java.net.*;
import java.util.List;

public class FileReceiverThread extends Thread {

    private ServerSocket serverSocket;

    public FileReceiverThread(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(() -> handleConnection(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleConnection(Socket socket) {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            String messageType = dis.readUTF();
            System.out.println("Message Type Received: " + messageType);
        
            if ("PING".equals(messageType)) {
               
                System.out.println("Received PING from peer.");
            } else if ("FILE".equals(messageType)) {
                String senderAddress = socket.getInetAddress().toString() + ":" + socket.getPort(); 
                receiveFile(dis, senderAddress);  
            } else if ("REQUEST_FILE".equals(messageType)) {
                String fileName = dis.readUTF();  
                System.out.println("Received file request for: " + fileName);
              
                File file = new File("shared", fileName);
                if (file.exists()) {
                    System.out.println("Sending file: " + fileName);
                    FileTransferHandler.sendFile(file, socket);  
                } else {
                    System.out.println("File " + fileName + " not found. Sending error.");
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeLong(-1); 
                }
            } else {
                System.out.println("Unknown message type: " + messageType);
            }
        } catch (IOException e) {
            System.err.println("Error handling connection: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  
   
    private void receiveFile(DataInputStream dis, String senderAddress) {
        try {
            String fileName = dis.readUTF();
            long fileSize = dis.readLong();  
          
            File dir = new File("shared");
            if (!dir.exists()) dir.mkdirs();  
    
           
            FileOutputStream fos = new FileOutputStream(new File(dir, fileName));
            byte[] buffer = new byte[4096];
            int bytesRead;
            long remaining = fileSize;
            while ((bytesRead = dis.read(buffer, 0, (int)Math.min(buffer.length, remaining))) > 0) {
                fos.write(buffer, 0, bytesRead);
                remaining -= bytesRead;
            }
    
            fos.close();
            System.out.println("Received: " + fileName);
    
           
            P2PUI.addReceivedFile(fileName, senderAddress);  
        } catch (IOException e) {
            System.err.println("Error receiving file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
