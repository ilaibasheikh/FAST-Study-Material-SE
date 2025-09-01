class CarbonFootprint {
    public double getCarbonFootPrint() {
        return 0.0;
    }
}
class Building extends CarbonFootprint {
     int numberOfBurners;
    public Building(int numberOfBurners) {
        this.numberOfBurners = numberOfBurners;
    }
    @Override
    public double getCarbonFootPrint() {
        System.out.println("Building:");
        return numberOfBurners * 22.14;
    }
}
class Car extends CarbonFootprint {
     double distance;
     double fuel;
    public Car(double distanceTravelled, double fuelPerKM) {
        this.distance = distanceTravelled;
        this.fuel = fuelPerKM;
    }
    @Override
    public double getCarbonFootPrint() {
        System.out.println("Car:");
        return distance * fuel * 22.14;
    }
}
class Bicycle extends CarbonFootprint {
    @Override
    public double getCarbonFootPrint() {
        System.out.println("Bicycle:");
        return 0.0;
    }
}
public class q8 {
    public static void main(String[] args) {
        CarbonFootprint[] c = new CarbonFootprint[3];
        c[0] = new Building(5);
        c[1] = new Car(100, 0.05);
        c[2] = new Bicycle();
        for (CarbonFootprint a : c) {
            System.out.println("Carbon Footprint: " + a.getCarbonFootPrint());
        }
    }
}


