class Car{
    private String carname;
    private String cartype;

    public Car(String carname, String cartype) {
        this.carname = carname;
        this.cartype = cartype;
    }
    public String getCarname(){
        return carname;
    }
    class Engine {
        public String enginetype;
        public void setEngine(){
            if (cartype == "4T"){
                if (carname == "Mehran"){
                    enginetype = "Small";
                }
                else{
                    enginetype = "Large";
                }
            }
            else{
                enginetype = "Bigger";
            }
        }

        public String getEnginetype() {
            return enginetype;
        }
    }

}

public class q5 {
    public static void main(String[] args) {
        Car c = new Car("Mehran" , "4T");
        Car.Engine e = c.new Engine();
        e.setEngine();
        System.out.println("Details: "+ e.getEnginetype());
        Car a = new Car("Audi", "4T");
        Car.Engine b = a.new Engine();
        b.setEngine();
        System.out.println("Details: "+ b.getEnginetype());
        Car d = new Car("Civic", "7T");
        Car.Engine f = d.new Engine();
        f.setEngine();
        System.out.println("Details: "+ f.getEnginetype());
    }
}
