public class Peer {
    public static void main(String[] args) {
        try {
            
            int port = args.length > 0 ? Integer.parseInt(args[0]) : 9999;

            
            String localAddress = "localhost:" + port;
            String[] activePeers = PeerClient.discoverPeers(localAddress);

            System.out.println("=== Peer Node Started ===");
            System.out.println("Listening on: " + localAddress);
            System.out.println("Active Peers:");
            for (String peer : activePeers) {
                System.out.println(" - " + peer);
            }

            
            P2PUI.main(new String[]{String.valueOf(port)});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
