class car {

    private int regno; // private data to hold registration number

    public car(){ } // null constructor

    public car(int r){
        // assign user define data into the objects private data
        regno=r;
    }

    public car (car c){
        //copy data of object passed as (c) to new object
        regno=c.regno;
    }

    public void getinfo(){
        // use to print the objects data
        System.out.println(" REG NO=" +regno);
    }
} //class closed

// new class to declare main(), so that objects access data from outside the class

public class M{

    public static void main( String args[]){
        // create an object
		car c=new car();
        car c2=new car(1110);
        car c1=new car(c2);

        // calling function with the ref of an object
        c1.getinfo();
    }
}