import com.sun.security.jgss.GSSUtil;

public class q3Vehicle {
    protected int Speed;
    protected String colour;
    protected int wheels;

    public q3Vehicle() {
    }

    public q3Vehicle(int a, String b, int c) {
        this.Speed = a;
        this.colour = b;
        this.wheels = c;

    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}

class MotorVehicle extends q3Vehicle{
    protected String licenseplate;

    public MotorVehicle(int a, String b, int c, String d) {
        super(a,b,c);
        this.licenseplate = d;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }
}

class Car extends MotorVehicle{
    protected int doors;

    public Car(int a, String b, int c, String d, int e) {
        super(a,b,c,d);
        this.doors=e;
    }


    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void display(){
        System.out.println(Speed);
        System.out.println(colour);
        System.out.println(wheels);
        System.out.println(licenseplate);
        System.out.println(doors);

    }

    public static void main(String[] args) {
        Car c = new Car(25,"Black", 4,"CS1001",4);
        c.display();
    }
}