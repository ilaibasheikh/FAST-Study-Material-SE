class CPU{
    private double price;
    class Processor{
        public double cores;
        public String manufacturer;
        public double getCache(){
            return 4.2;
        }
    }
    protected class RAM{
        public double memory;
        public String manufacturer;
        public double getClockSpeed(){
            return 5.3;
        }
    }


}
public class q3 {
    public static void main(String[] args) {
        CPU c = new CPU();
        CPU.Processor p = c.new Processor();
        CPU.RAM r = c.new RAM();
        System.out.println("Processor: " +p.getCache());
        System.out.println("RAM: " +r.getClockSpeed());
    }
}
