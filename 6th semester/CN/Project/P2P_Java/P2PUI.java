import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class P2PUI {
    public static void main(String[] args) throws Exception {
        // Default port if none provided
        int localPort = 9999;
        if (args.length > 0) {
            try {
                localPort = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid port. Using default 9999.");
            }
        }

        String localAddress = "localhost:" + localPort;

        // Start listening for incoming files
        new FileReceiverThread(localPort).start();

        JFrame frame = new JFrame("P2P File Sharing - Port " + localPort);
        JButton sendButton = new JButton("Send File");
        JTextArea peersArea = new JTextArea(10, 30);
        peersArea.setEditable(false);

        sendButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();

                String[] peers = PeerClient.discoverPeers(localAddress);
                for (String peer : peers) {
                    if (!peer.equals(localAddress)) {
                        String[] parts = peer.split(":");
                        try {
                            FileTransferHandler.sendFile(selectedFile, parts[0], Integer.parseInt(parts[1]));
                            JOptionPane.showMessageDialog(frame, "Sent to: " + peer);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(frame, "Failed to send to: " + peer);
                        }
                    }
                }
            }
        });

        JButton refreshPeers = new JButton("Refresh Peers");
        refreshPeers.addActionListener(e -> {
            String[] peers = PeerClient.discoverPeers(localAddress);
            peersArea.setText(String.join("\n", peers));
        });

        JPanel panel = new JPanel();
        panel.add(sendButton);
        panel.add(refreshPeers);
        panel.add(new JScrollPane(peersArea));

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
