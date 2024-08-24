class House{
    class Room{
        private String roomtype;
        private int roomsize;
        private float roomtemperature;

        public Room(String roomtype, int roomsize, float roomtemperature) {
            this.roomtype = roomtype;
            this.roomsize = roomsize;
            this.roomtemperature = roomtemperature;
        }

        public String getRoomtype() {
            return roomtype;
        }

        public void setRoomtype(String roomtype) {
            this.roomtype = roomtype;
        }

        public int getRoomsize() {
            return roomsize;
        }

        public void setRoomsize(int roomsize) {
            this.roomsize = roomsize;
        }

        public float getRoomtemperature() {
            return roomtemperature;
        }

        public void setRoomtemperature(float roomtemperature) {
            this.roomtemperature = roomtemperature;
        }
        public void display(){
            System.out.println("Details: ");
            System.out.println(getRoomtype());
            System.out.println(getRoomsize());
            System.out.println(getRoomtemperature());
        }
    }

}
public class q2 {
    public static void main(String[] args) {
        House h = new House();
        House.Room r = h.new Room("Bedroom", 5, 48.4f);
        r.display();
    }
}