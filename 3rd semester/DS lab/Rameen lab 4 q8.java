public class q {
    int data;
    q next;
    q head;
    public q(int d){
        data = d;
        next = null;
    }
    public void print(q obj) {
        q current = obj;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("null");
    }
    public q extracteven(q obj) {
        q current = obj;
        q extracted = null;
        q extractedlist = null;
        while(current!=null && current.next!=null){
            if(extracted==null) {
                extracted = new q(current.next.data);
                extractedlist = extracted;
            }
            else{
                extractedlist.next = new q(current.next.data);
                extractedlist = extractedlist.next;
            }
            current = current.next.next; //skipping an element
        }
        return extracted;
    }
    public q extractodd(q obj) {
        q current = obj;
        q extracted = null;
        q extractedlist = null;
        while(current!=null && current.next!=null){
            if(extracted==null) {
                extracted = new q(current.data);
                extractedlist = extracted;
            }
            else{
                extractedlist.next = new q(current.data);
                extractedlist = extractedlist.next;
            }
            current = current.next.next; //skipping an element
        }
        return extracted;
    }
    public q reverse(q obj) {
        q current = obj;
        q previous = null;
        q after = null;
        while(current != null) {
            after = current.next;
            current.next = previous; // Reverse the next pointer
            previous = current;
            current = after;
        }
        return previous;
    }
    public q append(q list1, q list2) {
        q current = list1;
        while(current.next != null) {
            current = current.next;
        }
        current.next = list2;
        return list1;
    }

    public static void main(String[] args) {
        q obj1 = new q(10);
        q obj2 = new q(4);
        q obj3 = new q(9);
        q obj4 = new q(1);
        q obj5 = new q(3);
        q obj6 = new q(5);
        q obj7 = new q(9);
        q obj8 = new q(4);
        obj1.next = obj2;
        obj2.next = obj3;
        obj3.next = obj4;
        obj4.next = obj5;
        obj5.next = obj6;
        obj6.next = obj7;
        obj7.next = obj8;
        obj1.head = obj1;
        System.out.println("Current List: ");
        obj1.print(obj1);
        //alternate even List:
        q evenlist = obj1.extracteven(obj1);
        //alternate odd list
        q oddlist = obj1.extractodd(obj1);
        //reverse even list
        q reverse = obj1.reverse(evenlist);
        //append list
        q append = obj1.append(oddlist, reverse);
        System.out.println("Appended list: ");
        obj1.print(append);
    }
}
