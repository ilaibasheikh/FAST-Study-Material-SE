import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class P2PUI {
    private static DefaultListModel<String> peerListModel = new DefaultListModel<>();
    private static DefaultTableModel fileTableModel;
    private static DefaultTableModel downloadTableModel;
  
    private static JTable fileTable;
    private static JTable downloadTable;
    private static JList<String> peerList;
    private static JFrame frame;
    private static String localAddress;

    public static void main(String[] args) throws Exception {
        int localPort = 9999;
        if (args.length > 0) {
            try {
                localPort = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid port. Using default 9999.");
            }
        }

        localAddress = "localhost:" + localPort;

        
        new FileReceiverThread(localPort).start();
        
        
        setupUI(localPort);

        
        refreshSharedFiles();

        
        refreshPeers();
    }

    private static void setupUI(int localPort) {
        frame = new JFrame("P2P File Sharing - Port " + localPort);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        
        JPanel leftPanel = new JPanel(new BorderLayout());
        peerList = new JList<>(peerListModel);
        peerList.setCellRenderer(new PeerCellRenderer());
        JScrollPane peerScroll = new JScrollPane(peerList);
        peerScroll.setBorder(BorderFactory.createTitledBorder("Peers"));

        JButton refreshPeersButton = new JButton("Refresh Peers");
        refreshPeersButton.addActionListener(e -> refreshPeers());

        leftPanel.add(peerScroll, BorderLayout.CENTER);
        leftPanel.add(refreshPeersButton, BorderLayout.SOUTH);

        
        fileTableModel = new DefaultTableModel(new String[]{"File Name", "Size (KB)", "Owner"}, 0);
        fileTable = new JTable(fileTableModel);
        fileTable.setRowHeight(30);  

        JScrollPane fileScrollPane = new JScrollPane(fileTable);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, fileScrollPane);
        mainSplitPane.setResizeWeight(0.3); 
        mainSplitPane.setDividerLocation(250); 

        frame.add(mainSplitPane, BorderLayout.CENTER);

        JButton refreshFilesButton = new JButton("Refresh Files");
        refreshFilesButton.addActionListener(e -> refreshSharedFiles());

        JPanel filePanel = new JPanel(new BorderLayout());
        filePanel.add(new JLabel("Shared Files:"), BorderLayout.NORTH);
        filePanel.add(fileScrollPane, BorderLayout.CENTER);
        filePanel.add(refreshFilesButton, BorderLayout.SOUTH);

        
        JPanel buttonPanel = new JPanel();
        JButton shareFileButton = new JButton("Share File");
        JButton downloadFileButton = new JButton("Download File");

        shareFileButton.addActionListener(e -> shareFileAction());
        downloadFileButton.addActionListener(e -> downloadFileAction());

        buttonPanel.add(shareFileButton);
        buttonPanel.add(downloadFileButton);

        
        downloadTableModel = new DefaultTableModel(new String[]{"File Name", "Size (KB)", "Progress"}, 0);
        downloadTable = new JTable(downloadTableModel);
        downloadTable.getColumn("Progress").setCellRenderer(new ProgressBarRenderer());
        JScrollPane downloadScrollPane = new JScrollPane(downloadTable);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(downloadScrollPane, BorderLayout.CENTER);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(filePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void addReceivedFile(String fileName, String ownerAddress) {
        SwingUtilities.invokeLater(() -> {
            
            File file = new File("shared", fileName);
            fileTableModel.addRow(new Object[]{
                file.getName(),                        
                file.length() / 1024,                  
                ownerAddress                           
            });
        });
    }

    private static void refreshPeers() {
        String[] peers = PeerClient.discoverPeers(localAddress);
        peerListModel.clear();
        for (String peer : peers) {
            if (!peer.equals(localAddress)) {
                String[] parts = peer.split(":");
                String host = parts[0];
                int port = Integer.parseInt(parts[1]);

                boolean online = isPeerOnline(host, port);
                if (online) {
                    peerListModel.addElement(peer + " (Online)");
                } else {
                    peerListModel.addElement(peer + " (Offline)");
                }
            }
        }
    }

    
    private static boolean isPeerOnline(String host, int port) {
        System.out.println("Checking if peer is online at: " + host + ":" + port); 
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 1000);
            return true;  
        } catch (IOException e) {
            System.out.println("Peer at " + host + ":" + port + " is offline.");
            return false;  
        }
    }

    private static void refreshSharedFiles() {
        fileTableModel.setRowCount(0);
        File sharedFolder = new File("shared");
        if (!sharedFolder.exists()) {
            sharedFolder.mkdirs();
        }
        for (File file : sharedFolder.listFiles()) {
            if (file.isFile()) {
                fileTableModel.addRow(new Object[]{
                    file.getName(),
                    file.length() / 1024,  
                    localAddress          
                });
            }
        }
    }
  
  

   

    private static void shareFileAction() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            File sharedFolder = new File("shared");
            if (!sharedFolder.exists()) {
                sharedFolder.mkdirs();
            }
            try {
                String ownerAddress = localAddress; 
    
                
                FileInputStream in = new FileInputStream(selectedFile);
                FileOutputStream out = new FileOutputStream(new File(sharedFolder, selectedFile.getName()));
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytesRead);
                }
                in.close();
                out.close();
    
                
                fileTableModel.addRow(new Object[]{
                    selectedFile.getName(),
                    selectedFile.length() / 1024,  
                    ownerAddress 
                });
    
                
                
    
                JOptionPane.showMessageDialog(frame, "File shared successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error sharing file.");
            }
        }
    }

    private static void downloadFileAction() {
        int selectedRow = fileTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a file to download.");
            return;
        }
    
        String fileName = (String) fileTableModel.getValueAt(selectedRow, 0);

        String owner = (String) fileTableModel.getValueAt(selectedRow, 2); 
    
        String[] ownerParts = owner.split(":");
        String host = ownerParts[0];
        int port = Integer.parseInt(ownerParts[1]);
    
        
        if (!isPeerOnline(host, port)) {
            JOptionPane.showMessageDialog(frame, "Owner peer is OFFLINE now. Cannot download.");
            return;
        }
    
        new Thread(() -> {
            try {
                
                FileTransferHandler.downloadFile(fileName, host, port);
                addDownloadProgress(fileName, 100); 
                JOptionPane.showMessageDialog(frame, "File downloaded successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(frame, "Failed to download file. Owner might have gone offline.")
                );
            }
        }).start();
    }
   


    private static void addDownloadProgress(String fileName, int progress) {
        SwingUtilities.invokeLater(() -> {
            downloadTableModel.addRow(new Object[]{
                fileName,
                "100",
                progress
            });
        });
    }

    
    static class PeerCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String text = value.toString();
            if (text.contains("Offline")) {
                label.setForeground(Color.GRAY);
            } else {
                label.setForeground(Color.BLACK);
            }
            return label;
        }
    }

    
    static class ProgressBarRenderer extends JProgressBar implements TableCellRenderer {
        public ProgressBarRenderer() {
            setStringPainted(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            if (value instanceof Integer) {
                int progress = (Integer) value;
                setValue(progress);
            }
            return this;
        }
    }
}