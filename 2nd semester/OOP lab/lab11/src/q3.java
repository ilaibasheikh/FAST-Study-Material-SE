import java.util.ArrayList;
import java.util.Scanner;

class swap<T> {
    public static <T> void Swap(ArrayList<Object> array, int index1,int index2){
        T temp;
        temp = (T) array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }
}
public class q3 {
    public static void main(String[] args) {
        ArrayList<Object> array = new ArrayList<>();

        array.add(19);
        array.add("Laiba");
        array.add("Mustafa");
        array.add("19");
        array.add(2003);
        System.out.println("enter the index number you want to swap");
        Scanner inp = new Scanner(System.in);
        int x,y;
        x = inp.nextInt();
        System.out.println("enter the next index you want to swap with");
        y = inp.nextInt();
        //  swap<Integer> swap = new swap<Integer>();
        swap.Swap(array,x,y);

        System.out.println(array);
    }
}