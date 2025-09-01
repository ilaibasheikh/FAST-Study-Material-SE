public class IBlock {
    {
        System.out.println("Instance initializer block 1");
    }
    static{
        System.out.println("HI ");
    }
    {
        System.out.println("Instance initializer block 2");
    }
    public IBlock () {
        System.out.println("Class constructor");
    }
    public static void main(String[] args) {
        IBlock ib = new IBlock();
        System.out.println("Main Method");
    }
}