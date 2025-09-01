public class destructorexample {
    public static void main(String[] args) {
            destructorexample de = new destructorexample();

            de.finalize();
            de = null;
            System.gc();
        System.out.println("Inside the main method");
    }

    protected void finalize(){
        System.out.println("object is destroyed");
    }
}
