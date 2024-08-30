public class q7 {
    int maximum(int a, int b)
    {
        if (a>b){
            System.out.println(a+" is the maximum ");
            return a;
        }
        else {
            System.out.println(b+" is the maximum ");
            return b;
        }
    }
    int maximum(int a, int b, int c){
        if (a>b && a>c){
            System.out.println(a+" is the maximum ");
            return a;
        }
        else if (b>a && b>c){
            System.out.println(b+" is the maximum ");
            return b;
        }
        else{
            System.out.println(c+" is the maximum ");
            return c;
        }
    }
    public static void main(String[] args) {
        q7 x = new q7();
        x.maximum(3,8);
        x.maximum(2,5,9);
    }
}
