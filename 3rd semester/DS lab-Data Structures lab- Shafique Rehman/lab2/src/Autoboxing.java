import java.util.ArrayList;

public class Autoboxing {
    public static void main(String[] args) {
        char ch = 'a';
        Character a = ch;
        ArrayList<Integer> array = new ArrayList<Integer>();
array.add(25);
        System.out.println(ch + " " + a);
        System.out.println(array.get(0));
    }
}
