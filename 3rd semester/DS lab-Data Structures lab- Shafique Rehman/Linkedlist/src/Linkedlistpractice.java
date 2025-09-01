import java.util.LinkedList;

public class Linkedlistpractice {
    class Node{
        Node next;
        Node prev;


    }

    public static void main(String[] args) {
        LinkedList<String> linkedlist= new LinkedList<String>();


//        linkedlist.push("a");
//        linkedlist.push("b");
//        linkedlist.push("c");
//        linkedlist.push("d");
//        linkedlist.push("e");
//        linkedlist.push("f");
//linkedlist.pop();


linkedlist.offer("A");
        linkedlist.offer("B");
        linkedlist.offer("C");
        linkedlist.offer("D");
        linkedlist.offer("E");
        linkedlist.offer("F");

        linkedlist.poll();

        linkedlist.add(4,"e");
        linkedlist.remove("e");

        //Searching


        System.out.println(linkedlist.indexOf("F"));
        System.out.println(linkedlist.peekFirst());
        System.out.println(linkedlist.peekLast());

linkedlist.addFirst("0");
linkedlist.addLast("G");
        System.out.println(linkedlist);

String first = linkedlist.removeFirst();
String last = linkedlist.removeLast();

        System.out.println(first);
        System.out.println(last);
        System.out.println(linkedlist);
    }

}
