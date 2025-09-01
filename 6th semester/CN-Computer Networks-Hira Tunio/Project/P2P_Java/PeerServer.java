import java.io.*;
import java.net.*;
import java.util.*;

public class PeerServer {
    public static final int PORT = 8888;
    private static Set<String> peers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("PeerServer started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> handlePeer(socket)).start();
        }
    }

    private static void handlePeer(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
             
            String peerInfo = in.readLine();
            synchronized (peers) {
                peers.add(peerInfo);
                out.println(String.join(",", peers));
            }
            System.out.println("New peer: " + peerInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
