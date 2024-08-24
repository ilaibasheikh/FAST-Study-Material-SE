public class q1Main {
    public static void main(String[] args) {
        System.out.println("Laiba Fatima 22K-5195");
        Room room = new Room("Drawing Room");
        Radiator rd1 = new Radiator();
        Radiator rd2 = new Radiator();
        System.out.println(room.isHeatedBy(rd1));
        System.out.println(room.isHeatedBy(rd2));
    }


}

 class Radiator{
   private int RadiatorID;
    boolean isOn;
    public static int nextID = 195;
     public Radiator() {
         this.RadiatorID = nextID;
         nextID = nextID + 15;
         this.isOn = false;
     }
     public int getRadiatorID() {
         return RadiatorID;
     }

     public void heats (Room room){
        room.isHeatedBy(this);
     }
 }

 class Room{
    String roomName;
    int seatingCapacty;
    int numRadiators;
    Radiator r1;
    Radiator r2;

    public Room(){}
     public Room(String roomName) {
         this.roomName = roomName;
         this.seatingCapacty = 12;
         this.numRadiators = 0;
         this.r1 = null;
         this.r2 = null;
     }

     public String isHeatedBy(Radiator r){
         if (r1 == r || r2 == r){
             return "Radiator already added to room.";
         }
         if (numRadiators>=2){
             return "Cannot add Radiator. Room has a maximum number of radiators.";
         }
         if (r1 == null) {
             r1 = r;
             numRadiators++;
             return "Radiator successfully added to room.";
         }
         if (r2 == null) {
             r2 = r;
             numRadiators++;
             return "Radiator successfully added to room.";
         }
         return "Cannot add Radiator. Room has a maximum number of radiators.";

     }
 }