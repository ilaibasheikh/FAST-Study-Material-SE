import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class fruit {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Mango");
        list.add("Banana");
        list.add("Grapes");
        list.add("Apple");

        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        Collections.sort(list);
        for(String fruit :list){
            System.out.println(fruit);
        }

    }
}
