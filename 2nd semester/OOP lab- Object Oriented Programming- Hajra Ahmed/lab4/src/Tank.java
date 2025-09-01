public class Tank {
    public int capacity;
    public Tank(){};
    public Tank(int t)
    {
        this.capacity=t;
    }

    public void fill(){
        capacity++;
    }
    public void empty(){
        capacity--;
    }
    protected void finalize(){
        System.out.println("Tank is empty");
    }

    public static void main(String[] args) {
        Tank t1= new Tank(1);
        System.out.println(t1.capacity);
        t1.fill();
        System.out.println(t1.capacity);
        t1.empty();
        System.out.println(t1.capacity);
        t1.empty();
        System.out.println(t1.capacity);
        t1.finalize();
        //either use finalize or you can equal it to null
        t1=null;
        System.out.println("Hey");
        System.gc();
        System.out.println("Bye");
    }
}
