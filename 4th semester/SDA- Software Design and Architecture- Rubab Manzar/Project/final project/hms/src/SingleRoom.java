
import java.io.Serializable;
import java.util.ArrayList;

public class SingleRoom implements Serializable {
    String name;
    String contact;
    String gender;
    int duration;
    ArrayList<Food> food = new ArrayList<>();
    ArrayList<Service> service = new ArrayList<>();

    SingleRoom() {
        this.name = "";
    }

    SingleRoom(String name, String contact, String gender, int duration) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.duration = duration;
    }
}

