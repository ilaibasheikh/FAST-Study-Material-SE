public class q6 {
    static int show(int a){
        System.out.println(a);
        return a;
    }

    static int show (int a , int b){
        System.out.println(a + " " +b);
        int sum = a+b;

        System.out.println("The sum is " + sum);
        return  sum;
    }
    public static void main(String[] args) {
        System.out.println("The num is 3");
        show(3);
        show(3,5);
    }
}
