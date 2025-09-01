import java.io.*;
import java.net.*;

public class PeerClient {
    public static String[] discoverPeers(String myAddress) {
        try (Socket socket = new Socket("localhost", PeerServer.PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(myAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String peerList = in.readLine();
            return peerList.split(",");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
