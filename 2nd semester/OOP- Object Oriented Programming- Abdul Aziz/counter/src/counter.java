public class counter{
    private int MAX=10;
    private int value;

    public void set(int a){
        MAX=a;
    }
    public void inc(){
        if( value < MAX ){
            ++value;
        }
    }

    public void getValue(){

        System.out.println (" The counter = " + value );
        System.out.println (" The Max = " + MAX);

    }
}
class temp{

    public static void main(String args[]){
        counter c1 = new counter();
        counter c2= new counter();
        counter c3 = new counter();
        counter c4 = new counter();

        counter c = new counter();
        c.set(20);
        c.inc();
        c.inc();
        c.getValue();
    }
}
