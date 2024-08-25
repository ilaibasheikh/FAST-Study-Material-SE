import java.util.ArrayList;

public class Unboxing {
    public static void main(String[] args) {
        Character ch = 'a';
        char a= ch;
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(24);
        int num = array.get(0);
        System.out.println(ch + " "+ a);
        System.out.println(num);
    }
}
