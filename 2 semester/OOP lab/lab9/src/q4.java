class Vehicle{
    private String name;
    private float engine;
    private String model;

    public Vehicle(){

    }

    public Vehicle(String name, int engine, String model) {
        this.name = name;
        this.engine = engine;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void display(){
        System.out.println("Details: ");
        System.out.println("Name: "+ name);
        System.out.println("Engine: "+engine);
        System.out.println("Model: "+model);
        class Owner{
            String ownername;
            int cnic;
            int phone;

            public Owner(String ownername, int cnic, int phone) {
                this.ownername = ownername;
                this.cnic = cnic;
                this.phone = phone;
            }

            public String getOwnername() {
                return ownername;
            }

            public void setOwnername(String ownername) {
                this.ownername = ownername;
            }

            public int getCnic() {
                return cnic;
            }

            public void setCnic(int cnic) {
                cnic = cnic;
            }

            public int getPhone() {
                return phone;
            }

            public void setPhone(int phone) {
                this.phone = phone;
            }
        }
        Owner o=new Owner("Laiba",123456,222);
        System.out.println("Cnic "+o.getCnic());
        System.out.println("Phone number "+o.getPhone());
        System.out.println("Owner: "+o.getOwnername());
    }

}

public class q4 {
    public static void main(String[] args) {
        Vehicle v=new Vehicle(){

            @Override
            public void display() {
                super.display();
            }
        };
        v.setName("Civic");
        v.setModel("Honda");
        v.setEngine(270);
        v.display();

    }
}

