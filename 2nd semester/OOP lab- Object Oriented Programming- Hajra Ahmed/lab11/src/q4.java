import java.util.ArrayList;

class Stack <T> {
    ArrayList <Object> array = new ArrayList<>();
    public <T> void push( T num){
        array.add(num);
    }
    public <T> void pop( T num){
        array.remove(num);
    }
    public <T> T peek(){
        return  (T) array.get(0);
    }
    public <T> void print(){
        System.out.println(array);
    }
    public <T> Boolean isEmpty(){
        return array.isEmpty();
    }

}

public class q4 {
    public static void main(String[] args) {
        Stack a = new Stack();
        System.out.println(a.isEmpty());
        a.push(4);
        a.push(6);
        a.push(2);
        a.pop(2);
        a.print();
    }
}