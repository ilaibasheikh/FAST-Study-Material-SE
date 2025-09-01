public class PeerInfo {
    String address;
    boolean online;

    public PeerInfo(String address, boolean online) {
        this.address = address;
        this.online = online;
    }

    public String toString() {
        return address + (online ? " (Online)" : " (Offline)");
    }
}
